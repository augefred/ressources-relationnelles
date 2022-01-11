package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentsControllerTest {


    @Autowired
    private MockMvc mvc;

    /*
    @Test
    public void getCommentByID() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/comments/10").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Commentaire d'Alfred")));
    }

/**/
}
