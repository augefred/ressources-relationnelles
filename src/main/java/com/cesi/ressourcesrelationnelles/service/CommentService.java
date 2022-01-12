package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> list() {
        return commentRepository.findAll();
    }

    public Comment createComment(Comment comment){
        return  commentRepository.save(comment);
    }
}
