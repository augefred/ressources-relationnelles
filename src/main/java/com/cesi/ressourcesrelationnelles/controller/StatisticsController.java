package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StatisticsController {
    Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    private StatisticService statService;


    public StatisticsController(StatisticService statService) {
        this.statService = statService;
    }

    @GetMapping("/statistics")
    public List<Statistic> getALlStatistic() {
        return statService.list();
    }

    @PostMapping("/statistics")
    public Statistic createStatistic(@RequestBody Statistic stat) {
        return statService.create(stat);
    }

    @DeleteMapping("/statistics/{id}")
    public void deleteStatistic(@PathVariable long id) {
        statService.delete(id);
    }

    @PutMapping("/statistics")
    public void updateStatistic(@RequestBody Statistic stat) {
        statService.update(stat);
    }

    @GetMapping("/statistics/{id}")
    public Statistic getStatistic(@PathVariable long id) {
        try {
            return statService.getStatistic(id);
        } catch (Exception e) {
            logger.warn("Statistic {} Not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
