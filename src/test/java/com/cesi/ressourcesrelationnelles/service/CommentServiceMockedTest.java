package com.cesi.ressourcesrelationnelles.service;
import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceMockedTest {

    @InjectMocks
    public CommentService commentService;

    @Mock
    public CommentRepository commentRepository;

    @BeforeTestClass
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void findCommentByIdMockTest(){
        List<Comment> mockComment = new ArrayList<>();
        mockComment.add(new Comment(1L,"pol", "bar","bar"));
        mockComment.add(new Comment(1L,"pol", "foo","foo"));

        Mockito.when(commentRepository.findAll()).thenReturn(mockComment);

        // when
        List<Comment> comments = commentService.list("bar");
        assertNotNull(comments);
        //Then
        assertEquals(1, comments.size());
    }

    @Test
    void findCommentByIdMockNoResultTest(){
        List<Comment> mockComment = new ArrayList<>();
        mockComment.add(new Comment(1L,"pol", "bar","bar"));
        mockComment.add(new Comment(1L,"pol", "foo","foo"));

        Mockito.when(commentRepository.findAll()).thenReturn(mockComment);

        // when
        List<Comment> comments = commentService.list("var");
        assertNotNull(comments);
        //Then
        assertEquals(0, comments.size());
    }
}
