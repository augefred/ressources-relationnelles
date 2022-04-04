package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Commentaire;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.service.CommentaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CommentaireController {

    Logger logger = LoggerFactory.getLogger(CommentaireController.class);

    public CommentaireController(CommentaireService commentService) {
        this.commentaireService = commentService;
    }

    private CommentaireService commentaireService;


    @GetMapping("/commentaire/{id}")
    public Commentaire getCommentaireById(@PathVariable("id")Long id) {
        try{
             return commentaireService.findById(id);
        }
        catch (NotFoundException e){
            logger.warn("Comment {} not found",id);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND ,e.getMessage(),e);
        }

    }

    @PutMapping("/commentaire/{id}")
    @ResponseBody
    public Commentaire updateCommentaire(@PathVariable long id, @RequestBody Commentaire comment) {
        comment.setCOM_ID(id);
        return commentaireService.updateComment(comment);
    }

    @DeleteMapping("/commentaire/{id}")
    public String deleteCommentaire(@PathVariable("id")Long id) {
        commentaireService.deleteComment(id);
        return "Comment supprimée";
    }

    @GetMapping("/commentaire")
    public List<Commentaire> getAllCommentaire(@RequestParam(required = false) String nameUserParentComment) {
        if (nameUserParentComment != null) {
            return commentaireService.list(nameUserParentComment);
        }
       return  commentaireService.list();
    }


    @PostMapping("/commentaire")
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire) {
        return commentaireService.createComment(commentaire);
    }


}