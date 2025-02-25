package com.nikilshyamsunder.learn_spring.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "first run", LocalDateTime.now(),
                LocalDateTime.now().plusHours(1), 3, Location.INDOOR));
        runs.add(new Run(2, "second run", LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusHours(1).plusDays(1), 6, Location.OUTDOOR));
    }

    public Optional<Run> findByID(int id) {
        return runs.stream().filter(run -> run.id() == id)
                .findFirst();
    }
}
