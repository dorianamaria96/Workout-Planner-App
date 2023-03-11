package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.service.ApiCallFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/categories")
public class CategoriesEndpoint {

    private final ApiCallFilter apiCallFilter;

    public CategoriesEndpoint(ApiCallFilter apiCallFilter) {
        this.apiCallFilter = apiCallFilter;
    }

    @GetMapping
    public Set<String> getCategories() {
        return apiCallFilter.getKeys();
    }

    @GetMapping("/{filter}")
    public Set<String> getFilterOptions(@PathVariable String filter) {
        return apiCallFilter.getFilterOptions(filter);
    }
}
