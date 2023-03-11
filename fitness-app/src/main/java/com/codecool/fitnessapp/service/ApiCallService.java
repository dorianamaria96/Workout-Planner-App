package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.service.dto.Filter;
import com.codecool.fitnessapp.service.records.ExercisesApi;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@EnableConfigurationProperties(ExercisesApi.class)
public class ApiCallService {

    private final ExercisesApi exercisesApi;

    public ApiCallService(ExercisesApi exercisesApi) {
        this.exercisesApi = exercisesApi;
    }

    public String getExercises(String apiKey, String api_path, String parameter, String value) throws IOException {
        URL url = new URL(api_path + "?" + parameter + "=" + value);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-API-Key", apiKey);
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public String getExercisesForFilter(Filter filter) throws IOException {
        return getExercises(exercisesApi.apiKey(), exercisesApi.apiPath(), filter.getParameter(), filter.getValue());
    }

    public String getExerciseByName(String nameOfExercise) throws IOException {
        return getExercises(exercisesApi.apiKey(), exercisesApi.apiPath(), "name", nameOfExercise);
    }
}
