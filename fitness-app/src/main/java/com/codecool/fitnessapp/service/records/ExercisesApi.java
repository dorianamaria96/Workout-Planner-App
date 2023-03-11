package com.codecool.fitnessapp.service.records;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("exercises")
public record ExercisesApi(String apiPath, String apiKey) {
}
