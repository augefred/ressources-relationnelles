package com.cesi.ressourcesrelationnelles.repository;

import com.cesi.ressourcesrelationnelles.domain.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RessourceRepository extends CrudRepository<Resource, Long> {
}
