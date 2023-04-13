package com.codecool.fitnessapp.service.dto;

import com.codecool.fitnessapp.entity.Gender;
import com.codecool.fitnessapp.entity.Goal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCreation {
    private double weight;
    private double height;
    private LocalDate birthday;
    private Gender gender;
    private List<Goal> goals;

}
