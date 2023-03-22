package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.entity.Image;
import com.codecool.fitnessapp.service.ImageService;
import com.codecool.fitnessapp.service.ProfileService;
import com.codecool.fitnessapp.service.exeption.ImageNotFoundException;
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

    public ProfileEndpoint(ProfileService profileService, ImageService imageService) {
        this.profileService = profileService;
        this.imageService = imageService;
    }

    @PostMapping("/image")
    public Image saveImage(@RequestParam("data") MultipartFile image) throws IOException {
        System.out.println("image = " + image);
        Image imageToSave = new Image(image.getOriginalFilename(), image.getContentType(), image.getBytes());
        System.out.println("imageToSave = " + imageToSave);
        System.out.println("NAME= " + imageToSave.getFileName());
        System.out.println("CONTENT = " + imageToSave.getFileType());
        System.out.println("BYTES = " + Arrays.toString(imageToSave.getData()));
        return imageService.saveImage(imageToSave);
    }

    @GetMapping("/image/{image-id}")
    public Image getImage(@PathVariable("image-id") String imageId) throws ImageNotFoundException {
        return imageService.getImage(imageId);
    }

}
