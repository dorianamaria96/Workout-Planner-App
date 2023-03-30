package com.codecool.fitnessapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToMany
    private Set<Muscle> muscleSet = new HashSet<>();

    public Exercise(String name, String description, Set<Muscle> muscleSet) {
        this.name = name;
        this.description = description;
        this.muscleSet = muscleSet;
    }
}