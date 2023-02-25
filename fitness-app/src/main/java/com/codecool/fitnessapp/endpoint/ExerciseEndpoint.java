package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.entity.Exercise;
import com.codecool.fitnessapp.service.ExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseEndpoint {

    private final ExerciseService exerciseService;

    public ExerciseEndpoint(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/all")
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }
}
