package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Commentaire;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.CommentaireRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentaireService commentService;

    @Autowired
    private CommentaireRepository commentRepository;


    @Test
    void createCommentTest(){
        commentRepository.deleteAll();

        commentService.createComment(new Commentaire());
        List<Commentaire> comments = commentService.list();
        assertEquals(comments.size(), 1);
    }

    @Test
    void deleteCommentTest(){
        commentRepository.deleteAll();
        Commentaire comment = commentService.createComment(new Commentaire());
        commentService.deleteComment(comment.getCOM_ID());
    }

    @Test
    void findCommentByIdTest() throws NotFoundException {
        commentRepository.deleteAll();

        Commentaire comment = commentService.createComment(new Commentaire());
        Commentaire actualComment = commentService.findById(comment.getCOM_ID());
        assertNotNull(actualComment);
    }

    @Test
    void findCommentByIdNoExistingTest() {
        commentRepository.deleteAll();

        assertThrowsExactly(NotFoundException.class, () -> {
            Commentaire actualComment = commentService.findById(-27);
        });
    }

    @Test
    void findCommentByContent(){
        //given
        commentRepository.deleteAll();

        commentService.createComment(new Commentaire(1L,"nom","ThatWhatSheSaid"));
        commentService.createComment(new Commentaire(1L,"prénom","ThatNotWhatSheSaid"));
        //when
        List<Commentaire> comments =   commentService.list("nomPopo");
        assertNotNull(comments);
        //then
        assertEquals(1,comments.size());
    }
}
