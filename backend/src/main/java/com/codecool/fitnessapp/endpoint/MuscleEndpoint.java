package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.entity.Muscle;
import com.codecool.fitnessapp.service.MuscleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/muscles")
public class MuscleEndpoint {

    private final MuscleService muscleService;

    public MuscleEndpoint(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping("/all")
    public List<Muscle> getAllMuscles() {
        return muscleService.getAllMuscles();
    }
}
