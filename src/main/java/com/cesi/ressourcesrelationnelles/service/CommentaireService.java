package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Commentaire;
import com.cesi.ressourcesrelationnelles.domain.Ressource;
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

    public List<Commentaire> list() {
        List<Commentaire> commentaires = new ArrayList<>();
        Iterable<Commentaire> iterable = commentRepository.findAll();
        for (Commentaire item : iterable) {
            commentaires.add(item);
        }
        return commentaires;
    }

    public Commentaire createComment(Commentaire comment){
        return  commentRepository.save(comment);
    }

    public Commentaire updateComment(Commentaire comment){
        return commentRepository.save(comment);
    }

    public void deleteComment(long id){
        commentRepository.deleteById(id);
    }

    public Commentaire findById(long id) throws NotFoundException {
        Optional<Commentaire> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            return optionalComment.get();

        } else {
            throw new NotFoundException("user not found");

        }
    }

    public List<Commentaire> list(String nameUserParentComment){
        List<Commentaire> commentaires = new ArrayList<>();
        Iterable<Commentaire> iterable = commentRepository.findAll();
        for (Commentaire item : iterable) {
            commentaires.add(item);
        }
        if (nameUserParentComment != null){
            commentaires = commentaires.stream().filter(comment ->
                comment.getCOM_Contenu().equals(nameUserParentComment)).collect(Collectors.toList());
        }
        return commentaires;
    }

}
