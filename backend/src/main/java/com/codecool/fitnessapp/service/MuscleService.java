package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.entity.Muscle;
import com.codecool.fitnessapp.repository.MuscleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleService {
    private final MuscleRepository muscleRepository;

    public MuscleService(MuscleRepository muscleRepository) {
        this.muscleRepository = muscleRepository;
    }

    public List<Muscle> getAllMuscles() {
        return muscleRepository.findAll();
    }
}
