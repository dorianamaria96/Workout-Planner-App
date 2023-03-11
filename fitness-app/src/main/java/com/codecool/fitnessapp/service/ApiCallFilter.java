package com.codecool.fitnessapp.service;

import com.codecool.fitnessapp.service.yamlPropertySource.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@ConfigurationProperties("filters")
@PropertySource(value = "classpath:filters.yml", factory = YamlPropertySourceFactory.class)
public class ApiCallFilter {
    private Map<String, Set<String>> filters;

    public Map<String, Set<String>> getFilters() {
        return filters;
    }
    public void setFilters(Map<String, Set<String>> filters) {
        this.filters = filters;
    }

    public Set<String> getKeys() {
        return filters.keySet();
    }

    public Set<String> getFilterOptions(String filter) {
        return filters.get(filter);
    }
}
