package com.codecool.fitnessapp.service.security_service;

import com.codecool.fitnessapp.entity.user.Role;
import com.codecool.fitnessapp.entity.user.User;
import com.codecool.fitnessapp.repository.UserRepository;
import com.codecool.fitnessapp.security.dto.RegisterRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public User register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        return userRepository.save(user);
    }

    public String login(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

}
