package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.CommentaireRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentaireService {


    private CommentaireRepository commentRepository;

    public CommentaireService(CommentaireRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> list() {
        List<Comment> commentaires = new ArrayList<>();
        Iterable<Comment> iterable = commentRepository.findAll();
        for (Comment item : iterable) {
            commentaires.add(item);
        }
        return commentaires;
    }

    public Comment createComment(Comment comment){
        return  commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment){
        return commentRepository.save(comment);
    }

    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }

    public Comment findById(long id) throws NotFoundException {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            return optionalComment.get();

        } else {
            throw new NotFoundException("user not found");

        }
    }

    public List<Comment> list(String nameUserParentComment){
        List<Comment> commentaires = new ArrayList<>();
        Iterable<Comment> iterable = commentRepository.findAll();
        for (Comment item : iterable) {
            commentaires.add(item);
        }
        if (nameUserParentComment != null){
            commentaires = commentaires.stream().filter(comment ->
                comment.getContent().equals(nameUserParentComment)).collect(Collectors.toList());
        }
        return commentaires;
    }

}
