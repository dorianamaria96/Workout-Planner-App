package com.codecool.fitnessapp.service.security_service;

import com.codecool.fitnessapp.entity.user.Role;
import com.codecool.fitnessapp.entity.user.User;
import com.codecool.fitnessapp.repository.UserRepository;
import com.codecool.fitnessapp.security.dto.RegisterRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthenticationService(JwtService jwtService, PasswordEncoder passwordEncoder,
                                 UserRepository userRepository) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isEmpty()){
            var user = User.builder()
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
            return "Success!";
        } else {
            return "Try again! It seems that the email you are using is already taken.";
        }

    }

    public String login(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

    public String getFirstNameOfLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No user is logged in."));
        return user.getFirstname();
    }
}
