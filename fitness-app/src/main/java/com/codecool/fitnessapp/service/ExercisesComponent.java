package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.service.records.ExercisesApi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties(ExercisesApi.class)
public class ExercisesComponent {

    @Bean
    String stringTest(ExercisesApi exercisesApi, ApiCallFilter apiCallFilter) {
        //ApiCallFilter apiCallFilter = new ApiCallFilter();
        System.out.println("MY RECORD" + exercisesApi.apiPath());
        System.out.println("MY FILTERS" + apiCallFilter.getFilters());
        //Create the filter
        return null;
    }
}
