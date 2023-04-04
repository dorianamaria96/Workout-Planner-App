package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.repository.ExerciseRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ExerciseServiceTest {
    ExerciseRepository exerciseRepository = mock(ExerciseRepository.class);
    ExerciseService exerciseService = new ExerciseService(exerciseRepository);

    @Test
    void getAllExercises() {
        exerciseRepository.findAll();

        verify(exerciseRepository).findAll();
    }
}