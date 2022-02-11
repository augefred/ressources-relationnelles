package com.cesi.ressourcesrelationnelles.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class StatisticsControllerTest {

    /*@Autowired
    private MockMvc mvc;

    @Test
    public void getStatistics() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/statistics").accept(MediaType.APPLICATION_JSON))
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        List<Statistic> responsesStatsList = new ObjectMapper().readValue(contentAsString, new TypeReference<>() {
        });
        assertNotNull(responsesStatsList);
    }*/
}
