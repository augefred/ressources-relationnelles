package com.cesi.ressourcesrelationnelles.repository;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
