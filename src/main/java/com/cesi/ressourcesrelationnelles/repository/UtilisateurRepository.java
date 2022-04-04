package com.cesi.ressourcesrelationnelles.repository;


import com.cesi.ressourcesrelationnelles.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
    }

