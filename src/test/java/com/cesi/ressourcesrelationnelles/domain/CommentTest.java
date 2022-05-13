package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommentTest {

    @Test
    public void createComment() {
        Comment comment = new Comment();
        comment.setContent("Un message généreux");
        Assert.notNull(comment);
        assertEquals("Un message généreux", comment.getContent());
    }


}
