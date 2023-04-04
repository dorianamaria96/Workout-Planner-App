package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.service.ExerciseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ExerciseEndpoint.class)
class ExerciseEndpointTest {

    @MockBean
    ExerciseService exerciseService;

    @Autowired
    MockMvc mockMvc;

    String url = "/exercises";

    @Test
    @WithMockUser
    void getAllExercises() throws Exception {
        String path = url + "/all";
        mockMvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(exerciseService).getAllExercises();
    }
}