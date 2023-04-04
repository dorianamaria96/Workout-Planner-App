package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.repository.ImageRepository;
import com.codecool.fitnessapp.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ImageRepository imageRepository;

    public ProfileService(ProfileRepository profileRepository, ImageRepository imageRepository) {
        this.profileRepository = profileRepository;
        this.imageRepository = imageRepository;
    }


}
