package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.entity.Goal;
import com.codecool.fitnessapp.entity.Profile;
import com.codecool.fitnessapp.entity.user.User;
import com.codecool.fitnessapp.repository.ProfileRepository;
import com.codecool.fitnessapp.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public Profile getProfileForLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No user is logged in."));
        return profileRepository.findProfileByUser(user);
    }

    public List<String> getAllGoals() {
        return Arrays.stream(Goal.values())
                .map(Enum::toString)
                .collect(Collectors.toList());
    }
}
