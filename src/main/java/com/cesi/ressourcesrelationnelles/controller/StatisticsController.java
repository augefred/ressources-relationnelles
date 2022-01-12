package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StatisticsController {
    @GetMapping("/statistics")
    public ArrayList<Statistic> getALlStatistic() {
        ArrayList<Statistic> listStats = new ArrayList<>();
        listStats.add(new Statistic(1, 1, 200));
        listStats.add(new Statistic(2, 2, 500));
        listStats.add(new Statistic(10, 15, 2589));
        return listStats;
    }
}
