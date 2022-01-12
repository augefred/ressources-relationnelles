package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CommentsController {
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
        List<Comment> comments = new ArrayList<>();
        Comment comment1= new Comment(1, "Jack", "JackParent","Message");
        Comment comment2= new Comment(2, "Elodie", "ElodieParent","Message");
        Comment comment3= new Comment(3, "Joe", "JoeParent","Message");
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        return   comments;
    }

/*
    @PostMapping("/comments/{commentmessage}")
    public String createComment(@PathVariable("commentmessage")String commentMessage) {
        String comment;
        comment = commentMessage;
        return "Le commantaire avec le Message : /n" + commentMessage + "/n a bien était ajouté";
    }
    /**/

}
