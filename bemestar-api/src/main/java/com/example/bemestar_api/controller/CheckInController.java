package com.example.bemestar_api.controller;

import com.example.bemestar_api.model.CheckIn;
import com.example.bemestar_api.repository.CheckInRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkins")
public class CheckInController {

    private final CheckInRepository repository;

    public CheckInController(CheckInRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<CheckIn> listar() {
        return repository.findAll();
    }

    @PostMapping
    public CheckIn salvar(@RequestBody CheckIn checkin) {
        return repository.save(checkin);
    }
}
