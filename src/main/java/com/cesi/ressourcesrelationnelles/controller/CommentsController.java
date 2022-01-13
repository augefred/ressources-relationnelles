package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.service.CommentService;
import org.springframework.web.bind.annotation.*;
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
        Optional<Comment> comment = commentService.getById(id);
        if(commentService.getById(id).isPresent()){
            return comment.get();
        }
        return new Comment();
    }

    @PutMapping("/comments")
    @ResponseBody
    public Comment updateComment(@RequestBody Comment comment) {
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
