package com.codecool.fitnessapp;

import com.codecool.fitnessapp.service.ApiCallFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FitnessAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FitnessAppApplication.class, args);
        ApiCallFilter apiCallFilter = context.getBean("apiCallFilter", ApiCallFilter.class);
        System.out.println("apiCallFilter = " + apiCallFilter.getFilters());
    }
}
