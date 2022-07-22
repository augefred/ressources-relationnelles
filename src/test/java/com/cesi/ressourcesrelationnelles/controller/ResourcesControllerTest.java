package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Category;
import com.cesi.ressourcesrelationnelles.domain.Resource;
import com.cesi.ressourcesrelationnelles.domain.Type;
import com.cesi.ressourcesrelationnelles.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class ResourcesControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getRessource() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/resource/1").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println("mvcResult : " + mvcResult.getResponse().getStatus());
        String content = mvcResult.getResponse().getContentAsString();
        Resource res = new ObjectMapper().readValue(content, Resource.class);
        assertNotNull(res);
        assertEquals(1, res.getId());
    }

    @Test
    void getRessources() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/resource/").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.println("mvcResult : " + mvcResult.getResponse().getStatus());
        String content = mvcResult.getResponse().getContentAsString();
        List<Resource> res = new ObjectMapper().readValue(content, List.class);
        assertNotNull(res);
        assertEquals(4, res.size());
    }
}
