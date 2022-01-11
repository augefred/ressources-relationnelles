package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentsController {

    @GetMapping("/GetComment?id")
    public String getCommentById(int id) {
        String comment;
        if (id == 10)
            comment = "Commentaire d'Alfred";
        else
            comment = "Aucun commentaire à l'id spécifié";

        return comment;
    }

    @PostMapping("/GetAllComment")
    public List<String> getAllComment() {
        List<String> comments = new ArrayList<>();
        comments.add("Commentaire de Jack");
        comments.add("Commentaire de Antoine");
        comments.add("Commentaire de Sylvie");

        return comments;
    }

    @GetMapping("/setComment?commentMessage")
    public String createComment(String commentMessage) {
        String comment;
        comment = commentMessage;
        return "Le commantaire avec le Message : /n" + commentMessage + "/n a bien était ajouté";
    }
}
