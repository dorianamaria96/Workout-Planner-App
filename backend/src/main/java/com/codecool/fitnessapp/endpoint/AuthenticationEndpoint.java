package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.security.dto.RegisterRequest;
import com.codecool.fitnessapp.service.security_service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationEndpoint {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        return authenticationService.login(authentication);
    }

    @GetMapping("/username")
    public String getFirstNameOfLoggedInUser() {
        return authenticationService.getFirstNameOfLoggedInUser();
    }
}
