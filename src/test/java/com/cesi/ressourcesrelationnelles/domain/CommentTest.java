package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommentTest {

    @Test
    public void createComment() {
        Commentaire comment = new Commentaire();
        comment.setCommentMessage("Un message généreux");
        Assert.notNull(comment);
        assertEquals("Un message généreux", comment.getCommentMessage());
    }


}
