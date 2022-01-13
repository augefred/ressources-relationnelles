package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;


    @Test
    void createCommentTest(){
        commentService.createComment(new Comment());
        List<Comment> comments = commentService.list();
        assertEquals(comments.size(), 1);
    }

    @Test
    void deleteCommentTest(){
        commentService.createComment(new Comment());
        commentService.deleteComment(1);
    }

    @Test
    void findUserByIdTest() throws NotFoundException {
        Comment comment = commentService.createComment(new Comment());
        Comment actualComment = commentService.findById(comment.getId());
        assertNotNull(actualComment);
    }

    @Test
    void findUserByIdNoExistingTest() {
        assertThrowsExactly(NotFoundException.class, () -> {
            Comment actualComment = commentService.findById(-27);
        });
    }
}
