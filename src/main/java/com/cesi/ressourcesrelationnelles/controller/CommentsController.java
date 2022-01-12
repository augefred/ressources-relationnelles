package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CommentsController {
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    private CommentService commentService;
/*
    @GetMapping("/comments/{id}")
    public String getCommentById(@PathVariable("id") int id) {
        String comment;
        if (id == 10)
            comment = "Commentaire d'Alfred";
        else
            comment = "Aucun commentaire à l'id spécifié";

        return comment;
    }
/**/

    @GetMapping("/comments")
    public List<Comment> getAllComment() {
       return  commentService.list();
    }


    @PostMapping("/comments")
    public Comment createComment(Comment comment) {
        return commentService.createComment(comment);
    }


}
