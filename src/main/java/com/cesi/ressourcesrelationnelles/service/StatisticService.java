package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    public StatisticService (StatisticRepository statisticRepository){
        this.statisticRepository = statisticRepository;
    }

    public List<Statistic> list(){
        return this.statisticRepository.findAll();
    }

    public Statistic create(Statistic statistic){
        return this.statisticRepository.save(statistic);
    }
}
