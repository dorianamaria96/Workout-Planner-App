package com.codecool.fitnessapp.endpoint;

import com.codecool.fitnessapp.service.ExerciseService;
import com.codecool.fitnessapp.service.MuscleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MuscleEndpoint.class)
class MuscleEndpointTest {

    @MockBean
    MuscleService muscleService;

    @Autowired
    MockMvc mockMvc;

    String url = "/muscles";

    @Test
    @WithMockUser
    void getAllMuscles () throws Exception {
        String path = url + "/all";

        mockMvc.perform(MockMvcRequestBuilders.get(path))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(muscleService).getAllMuscles();
    }

}