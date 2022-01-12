package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommentServiceTest {

    private CommentService commentService;

    public CommentServiceTest(CommentService commentService) {
        this.commentService = commentService;
    }

    @Test
    void createCommentTest(){
        commentService.createComment(new Comment());
        List<Comment> comments = commentService.list();
        assertEquals(comments.size(), 1);
    }
}
