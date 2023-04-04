package com.codecool.fitnessapp.entity;

import com.codecool.fitnessapp.entity.user.User;
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
public class Profile {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;

    private String lastname;

    private Double weight;

    private double height;

    @OneToMany
    private Set<Routine> routines;

    @ElementCollection(targetClass = Goal.class)
    @Enumerated(EnumType.STRING)
    private Set<Goal> goals;
    @OneToOne
    User user;
}
