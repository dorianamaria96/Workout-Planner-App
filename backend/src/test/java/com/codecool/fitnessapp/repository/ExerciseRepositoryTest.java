package com.codecool.fitnessapp.repository;

import com.codecool.fitnessapp.entity.Exercise;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ExerciseRepositoryTest {
    @Autowired
    ExerciseRepository exerciseRepository;

    Exercise exercise = new Exercise();

    @BeforeEach
    void before() {
        exerciseRepository.save(exercise);
    }

    @AfterEach
    void after() {
        exerciseRepository.delete(exercise);
    }

    @Test
    void findByNameFindsOne() {
        String name = "Exercise";
        Optional<Exercise> optionalExercise = exerciseRepository.findByName(name);

        assertTrue(optionalExercise.isPresent());
        assertEquals(name, optionalExercise.get().getName());
    }

    @Test
    void findByNameFindNone() {
        String name = "Non-Existent Exercise";
        Optional<Exercise> optionalExercise = exerciseRepository.findByName(name);

        assertTrue(optionalExercise.isEmpty());
    }
}