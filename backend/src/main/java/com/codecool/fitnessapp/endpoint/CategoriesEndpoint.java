package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.service.dto.ExerciseStructure;
import com.codecool.fitnessapp.service.dto.Filter;
import com.codecool.fitnessapp.service.ApiCallFilter;
import com.codecool.fitnessapp.service.ApiCallService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoriesEndpoint {

    private final ApiCallFilter apiCallFilter;
    private final ApiCallService apiCallService;

    public CategoriesEndpoint(ApiCallFilter apiCallFilter, ApiCallService apiCallService) {
        this.apiCallFilter = apiCallFilter;
        this.apiCallService = apiCallService;
    }

    @GetMapping
    public Set<String> getCategories() {
        return apiCallFilter.getKeys();
    }

    @GetMapping("/{filter}")
    public Set<String> getFilterOptions(@PathVariable String filter) {
        return apiCallFilter.getFilterOptions(filter);
    }

    @GetMapping("/chosenFilter/{parameter}/{value}")
    public String getChosenFilter(@PathVariable(name = "parameter") String parameter, @PathVariable(name = "value") String value) throws IOException {
        Filter filter = new Filter(parameter, value);
        return apiCallService.getExercisesForFilter(filter);
    }

//    @GetMapping("/{name}")
//    public String getExerciseByName(@PathVariable String name) throws IOException {
//        return apiCallService.getExerciseByName(name);
//    }
}
