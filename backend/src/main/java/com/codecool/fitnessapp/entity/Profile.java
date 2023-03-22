package com.codecool.fitnessapp.entity;

import com.codecool.fitnessapp.entity.user.User;
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
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Image image;
    @OneToOne
    User user;
}
