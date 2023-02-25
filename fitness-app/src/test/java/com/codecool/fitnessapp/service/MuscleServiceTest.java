package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.repository.MuscleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.*;

class MuscleServiceTest {
    MuscleRepository muscleRepository = Mockito.mock(MuscleRepository.class);
    MuscleService muscleService = new MuscleService(muscleRepository);

    @Test
    void getAllMuscles() {
        muscleRepository.findAll();

        Mockito.verify(muscleRepository).findAll();
    }
}