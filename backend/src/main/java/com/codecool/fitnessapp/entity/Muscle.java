package com.codecool.fitnessapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Muscle {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Muscle(String name) {
        this.name = name;
    }
}