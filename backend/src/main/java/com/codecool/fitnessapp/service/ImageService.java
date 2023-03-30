package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.entity.Image;
import com.codecool.fitnessapp.entity.user.User;
import com.codecool.fitnessapp.repository.ImageRepository;
import com.codecool.fitnessapp.repository.UserRepository;
import com.codecool.fitnessapp.service.exeption.ImageNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private UserRepository userRepository;

    public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    public Image saveImage(Image image) throws ImageNotFoundException {
        if (checkIfImageExists()) {
            Image existingImage = getImage();
            imageRepository.delete(existingImage);
        }
        return imageRepository.save(image);
    }

    @Transactional
    public Image getImage() throws ImageNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No user is logged in."));
        return imageRepository.findByUser(user).orElseThrow(() -> new ImageNotFoundException("No image found."));
    }

    public boolean checkIfImageExists() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No user is logged in."));
        return imageRepository.existsByUser(user);
    }
}
