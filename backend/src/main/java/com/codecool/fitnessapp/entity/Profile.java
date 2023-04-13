package com.codecool.fitnessapp.entity;

import com.codecool.fitnessapp.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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

    private double weight;

    private double height;

    private LocalDateTime birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany
    private Set<Routine> routines;

    @ElementCollection(targetClass = Goal.class)
    @Enumerated(EnumType.STRING)
    private Set<Goal> goals;
    @OneToOne
    User user;

    public Profile(String firstname, String lastname, double weight, double height, LocalDateTime birthday, Gender gender, Set<Routine> routines, Set<Goal> goals, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.weight = weight;
        this.height = height;
        this.birthday = birthday;
        this.gender = gender;
        this.routines = routines;
        this.goals = goals;
        this.user = user;
    }
}
