package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Statistic;
import com.cesi.ressourcesrelationnelles.service.StatisticService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class StatisticServiceTest {
    @Autowired
    private StatisticService statService;

    @Test
    public void statisticListTest() {
        List<Statistic> stats = statService.list();

        assertFalse(stats.isEmpty());
    }

    @Test
    public void createStatisticTest(){
        statService.create(new Statistic());
        List<Statistic> stats = statService.list();
        assertEquals(1, stats.size());
    }
}
