package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.entity.Profile;
import com.codecool.fitnessapp.entity.user.User;
import com.codecool.fitnessapp.repository.ProfileRepository;
import com.codecool.fitnessapp.repository.UserRepository;
import com.codecool.fitnessapp.security.dto.RegisterRequest;
import com.codecool.fitnessapp.service.security_service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationEndpoint {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

//    @PostMapping("/create-profile/{user-email}")
//    public Profile createProfileForRegisteredUser(@PathVariable("user-email") String email) {
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user with this email address."));
//        Profile profile = new Profile(user.getFirstname(), user.getLastname(), 0.0, 0.0, Set.of(), Set.of(), user);
//        return profileRepository.save(profile);
//    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        return authenticationService.login(authentication);
    }

    @GetMapping("/username")
    public String getFirstNameOfLoggedInUser() {
        return authenticationService.getFirstNameOfLoggedInUser();
    }

}
