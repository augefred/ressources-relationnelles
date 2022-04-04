package com.cesi.ressourcesrelationnelles.repository;

import com.cesi.ressourcesrelationnelles.domain.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Long> {
}