package com.codecool.fitnessapp.runner;

import com.codecool.fitnessapp.entity.Exercise;
import com.codecool.fitnessapp.entity.Muscle;
import com.codecool.fitnessapp.entity.user.User;
import com.codecool.fitnessapp.repository.ExerciseRepository;
import com.codecool.fitnessapp.repository.MuscleRepository;
import com.codecool.fitnessapp.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@Configuration
public class Initialization {

    @Bean
    ApplicationRunner applicationRunner(PasswordEncoder passwordEncoder, UserRepository userRepository, ExerciseRepository exerciseRepository, MuscleRepository muscleRepository) {
        return args -> {
            User user = new User("Doriana", "Maria", "dori@gmail.at", passwordEncoder.encode("123"));
            userRepository.save(user);
//
//            Muscle biceps = new Muscle("Biceps");
//            Muscle triceps = new Muscle("Triceps");
//            Muscle glutes = new Muscle("Glutes");
//            Muscle hamstrings = new Muscle("Hamstrings");
//            Muscle quadriceps = new Muscle("Quadriceps");
//            muscleRepository.saveAll(List.of(biceps, triceps, glutes, hamstrings, quadriceps));


//            Exercise squat = new Exercise("Squat", "Description", Set.of(hamstrings, quadriceps, glutes));
//            Exercise backExtension = new Exercise("Back Extension Glutes Focused", "Description", Set.of(hamstrings, glutes));
//            Exercise bicepCurls = new Exercise("Bicep Curls", "Description", Set.of(biceps));
//
//            exerciseRepository.saveAll(List.of(squat, bicepCurls, backExtension));

        };
    }
}
