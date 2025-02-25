package com.nikilshyamsunder.learn_spring.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs") // request mapping reduces code duplication
public class RunController {
    private final RunRepository runRepository;

    // provided by Spring thanks to @Repository annotation
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    // {dynamic path variable}
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> opt = runRepository.findByID(id);
        if (opt.isPresent()){
            return opt.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

}
