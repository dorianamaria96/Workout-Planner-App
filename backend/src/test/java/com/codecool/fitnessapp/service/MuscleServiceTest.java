package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.repository.MuscleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MuscleServiceTest {
    MuscleRepository muscleRepository = Mockito.mock(MuscleRepository.class);
    MuscleService muscleService = new MuscleService(muscleRepository);

    @Test
    void getAllMuscles() {
        muscleRepository.findAll();

        Mockito.verify(muscleRepository).findAll();
    }
}