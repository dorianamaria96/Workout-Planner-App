package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.service.dto.ExerciseStructure;
import com.codecool.fitnessapp.service.dto.Filter;
import com.codecool.fitnessapp.service.records.ExercisesApi;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonArray;
import com.nimbusds.jose.shaded.gson.JsonElement;
import com.nimbusds.jose.shaded.gson.JsonParser;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


@Service
@EnableConfigurationProperties(ExercisesApi.class)
public class ApiCallService {

    private final ExercisesApi exercisesApi;

    public ApiCallService(ExercisesApi exercisesApi) {
        this.exercisesApi = exercisesApi;
    }

    public String getExercises(String apiKey, String api_path, String parameter, String value) throws IOException {
        String encodedParameter = URLEncoder.encode(parameter, StandardCharsets.UTF_8);
        String encodedValue = URLEncoder.encode(value, StandardCharsets.UTF_8);
        URL url = new URL(api_path + "?" + encodedParameter + "=" + encodedValue);
        //URL url = new URL(api_path + "?" + parameter + "=" + value);
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
