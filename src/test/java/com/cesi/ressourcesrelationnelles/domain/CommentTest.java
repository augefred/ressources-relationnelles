package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CommentTest {

    @Test
    public void createComment() {
        Commentaire comment = new Commentaire();
        comment.setCOM_Contenu("Un message généreux");
        Assert.notNull(comment);
        assertEquals("Un message généreux", comment.getCOM_Contenu());
    }


}
