package com.codecool.fitnessapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Routine {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String notes;

    @ManyToMany
    private Set<Workout> workouts;
}