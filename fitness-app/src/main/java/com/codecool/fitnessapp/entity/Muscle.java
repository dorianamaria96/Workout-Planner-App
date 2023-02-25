package com.codecool.fitnessapp.entity;

import jakarta.persistence.*;
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
//    @ManyToOne
////    @JoinColumn(name = "exercise_id")
//    private Exercise exercise;

    public Muscle(String name) {
        this.name = name;
    }
}