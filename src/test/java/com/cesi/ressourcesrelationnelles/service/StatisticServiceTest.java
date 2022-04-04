package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatisticServiceTest {
    /*@Autowired
    private StatisticService statService;

    @Autowired
    private StatisticRepository statRepository;

    @Test
    public void statisticListTest() {
        List<Statistic> stats = statService.list();

        assertFalse(stats.isEmpty());
    }

    @Test
    public void createStatisticTest() {
        statRepository.deleteAll();

        statService.create(new Statistic());
        List<Statistic> stats = statService.list();
        assertEquals(1, stats.size());
    }

    @Test
    public void deleteStatisticTest() {
        statService.delete(1);
    }

    @Test
    public void findStatisticByIdTest() throws NotFoundException {
        statRepository.deleteAll();

        Statistic stat = statService.create(new Statistic());
        Statistic actualStat = statService.getStatistic(stat.getId());
        assertNotNull(actualStat);
    }

    @Test
    public void findStatisticByIdNoExistingTest() {
        statRepository.deleteAll();

        assertThrowsExactly(NotFoundException.class, () -> {
            Statistic actualStat = statService.getStatistic(-27);
        });
    }

    @Test
    public void findStatisticByNbVuesNoResultTest() {
        statRepository.deleteAll();

        statService.create(new Statistic(1, 1, 200));
        statService.create(new Statistic(2, 1, 250));
        statService.create(new Statistic(3, 1, 300));
        List<Statistic> stats = statService.list(1234567891);
        assertNotNull(stats);
        assertEquals(0, stats.size());
    }*/
}
