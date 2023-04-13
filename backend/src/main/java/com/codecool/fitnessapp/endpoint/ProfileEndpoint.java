package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.entity.Image;
import com.codecool.fitnessapp.entity.Profile;
import com.codecool.fitnessapp.entity.user.User;
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
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileEndpoint {

    private final ProfileService profileService;
    private final ImageService imageService;
    private final UserRepository userRepository;

    public ProfileEndpoint(ProfileService profileService, ImageService imageService, UserRepository userRepository) {
        this.profileService = profileService;
        this.imageService = imageService;
        this.userRepository = userRepository;
    }

    @PostMapping("/image")
    public Image saveImage(@RequestParam("data") MultipartFile image) throws IOException, ImageNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No user is logged in."));
        Image imageToSave = new Image(image.getOriginalFilename(), image.getContentType(), image.getBytes(), user);
        return imageService.saveImage(imageToSave);
    }

    @GetMapping("/image")
    public Image getImage() throws ImageNotFoundException {
        return imageService.getImage();
    }

    @GetMapping("/image/find-if-exists")
    public boolean checkIfImageExists() {
        return imageService.checkIfImageExists();
    }

    @GetMapping("/user-profile")
    public Profile getProfileForLoggedInUser() {
        return profileService.getProfileForLoggedInUser();
    }

    @GetMapping("/goals")
    public List<String> getAllGoals () {
        return profileService.getAllGoals();
    }
}
