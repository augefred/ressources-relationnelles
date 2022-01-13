package com.cesi.ressourcesrelationnelles.repository;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
