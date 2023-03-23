package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.entity.Image;
import com.codecool.fitnessapp.entity.user.User;
import com.codecool.fitnessapp.repository.ImageRepository;
import com.codecool.fitnessapp.repository.UserRepository;
import com.codecool.fitnessapp.service.ImageService;
import com.codecool.fitnessapp.service.ProfileService;
import com.codecool.fitnessapp.service.exeption.ImageNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileEndpoint {

    private final ProfileService profileService;

    private final ImageService imageService;
    private UserRepository userRepository;
    private final ImageRepository imageRepository;

    public ProfileEndpoint(ProfileService profileService, ImageService imageService, UserRepository userRepository,
                           ImageRepository imageRepository) {
        this.profileService = profileService;
        this.imageService = imageService;
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
    }

    @PostMapping("/image")
    public Image saveImage(@RequestParam("data") MultipartFile image) throws IOException, ImageNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No user is logged in."));
        if (imageService.checkIfImageExists()) {
            Image existingImage = imageService.getImage();
            imageRepository.delete(existingImage);
        }
        Image imageToSave = new Image(image.getOriginalFilename(), image.getContentType(), image.getBytes(), user);
        return imageService.saveImage(imageToSave);
    }

    @GetMapping("/image")
    public Image getImage() throws ImageNotFoundException {
        return imageService.getImage();
    }

    @GetMapping("/image/find-if-exists")
    public boolean checkIfImageExists() {
        System.out.println("imageService = " + imageService.checkIfImageExists());
        return imageService.checkIfImageExists();
    }
}
