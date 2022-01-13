package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<Statistic> list() {
        return this.statisticRepository.findAll();
    }

    public List<Statistic> list(int nbVues) {
        List<Statistic> listStats = this.statisticRepository.findAll();
        listStats = listStats.stream().filter(stat -> (stat.getNbVues() == nbVues)).collect(Collectors.toList());
        return listStats;
    }

    public Statistic create(Statistic statistic) {
        return this.statisticRepository.save(statistic);
    }

    public void delete(long id) {
        Optional<Statistic> stat = this.statisticRepository.findById(id);
        if (stat.isPresent()) {
            this.statisticRepository.delete(this.statisticRepository.getById(id));
        }
    }

    public void update(Statistic statistic) {
        Optional<Statistic> stat = this.statisticRepository.findById(statistic.getId());
        if (stat.isPresent()) {
            this.statisticRepository.save(statistic);
        }
    }

    public Statistic getStatistic(long id) throws NotFoundException {
        return this.statisticRepository.findById(id).orElseThrow(() -> new NotFoundException("Statistique non trouvée"));
    }
}
