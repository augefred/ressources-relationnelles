package com.cesi.ressourcesrelationnelles.repository;


import com.cesi.ressourcesrelationnelles.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
    }

