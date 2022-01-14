package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.CommentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<Comment> comments = commentRepository.findAll();
        if (nameUserParentComment != null){
            comments = comments.stream().filter(comment ->
                comment.getNameUserParentComment().equals(nameUserParentComment)).collect(Collectors.toList());
        }
        return comments;
    }

}
