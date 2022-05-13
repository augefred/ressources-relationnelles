package com.cesi.ressourcesrelationnelles.repository;

import com.cesi.ressourcesrelationnelles.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends CrudRepository<Comment, Long> {
}
