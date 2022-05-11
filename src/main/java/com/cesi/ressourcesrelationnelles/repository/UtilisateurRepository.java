package com.cesi.ressourcesrelationnelles.repository;


import com.cesi.ressourcesrelationnelles.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UtilisateurRepository extends CrudRepository<User, Long> {
    }

