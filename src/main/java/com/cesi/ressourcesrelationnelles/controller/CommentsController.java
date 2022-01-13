package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentsController {
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    private CommentService commentService;


    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable("id")Long id) {
        try{
             return commentService.findById(id);
        }
        catch (NotFoundException e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND ,e.getMessage(),e);
        }

    }

    @PutMapping("/comments/{id}")
    @ResponseBody
    public Comment updateComment(@PathVariable long id,@RequestBody Comment comment) {
        comment.setId(id);
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/comments/{id}")
    public String deleteComment(@PathVariable("id")Long id) {
        commentService.deleteComment(id);
        return "Comment supprimée";
    }

    @GetMapping("/comments")
    public List<Comment> getAllComment() {
       return  commentService.list();
    }


    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }


}
