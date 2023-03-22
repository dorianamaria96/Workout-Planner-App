package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.entity.Image;
import com.codecool.fitnessapp.repository.ImageRepository;
import com.codecool.fitnessapp.service.exeption.ImageNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public Image getImage(String imageId) throws ImageNotFoundException {
        return imageRepository.findById(Long.parseLong(imageId)).orElseThrow(() -> new ImageNotFoundException("Image doesn't exist."));
    }
}
