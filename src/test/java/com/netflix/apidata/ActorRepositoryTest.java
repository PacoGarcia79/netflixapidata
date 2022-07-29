package com.netflix.apidata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.apidata.entity.Actor;
import com.netflix.apidata.repository.ActorRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ActorRepository.class)
public class ActorRepositoryTest {

    @MockBean
    private ActorRepository actorRepository;

    @Autowired
    private MockMvc mockMvc;





    @Test
    @WithMockUser(username = "admin", password = "1234", roles = { "USER" })
    void saveTest() throws Exception {
        Actor test = new Actor("Genry");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(test);

        mockMvc.perform(MockMvcRequestBuilders.post("/actor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void showAllTest() throws Exception {
        Actor test1 = new Actor("Test");
        Actor test2 = new Actor("Test2");

        Mockito.when(actorRepository.findAll()).thenReturn(Arrays.asList(test1, test2));


        mockMvc.perform(MockMvcRequestBuilders.get("/actor")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("Test2"));
    }



}