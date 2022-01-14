package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;


    @Test
    void createCommentTest(){
        commentRepository.deleteAll();

        commentService.createComment(new Comment());
        List<Comment> comments = commentService.list();
        assertEquals(comments.size(), 1);
    }

    @Test
    void deleteCommentTest(){
        commentRepository.deleteAll();

        commentService.createComment(new Comment());
        commentService.deleteComment(1);
    }

    @Test
    void findCommentByIdTest() throws NotFoundException {
        commentRepository.deleteAll();

        Comment comment = commentService.createComment(new Comment());
        Comment actualComment = commentService.findById(comment.getId());
        assertNotNull(actualComment);
    }

    @Test
    void findCommentByIdNoExistingTest() {
        commentRepository.deleteAll();

        assertThrowsExactly(NotFoundException.class, () -> {
            Comment actualComment = commentService.findById(-27);
        });
    }

    @Test
    void findCommentByContent(){
        //given
        commentRepository.deleteAll();

        commentService.createComment(new Comment(1L,"nom","nomPapa","ThatWhatSheSaid"));
        commentService.createComment(new Comment(1L,"prénom","nomPopo","ThatNotWhatSheSaid"));
        //when
        List<Comment> comments =   commentService.list("nomPopo");
        assertNotNull(comments);
        //then
        assertEquals(1,comments.size());
    }
}
