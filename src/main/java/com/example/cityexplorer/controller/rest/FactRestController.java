package com.example.cityexplorer.controller.rest;

import com.example.cityexplorer.model.Fact;
import com.example.cityexplorer.service.IFactService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fact")
public class FactRestController {

    private final IFactService factService;

    public FactRestController(IFactService factService) {
        this.factService = factService;
    }

    @GetMapping("{id}")
    public Fact get(@PathVariable Long id) {
        return factService.get(id);
    }

    @PostMapping
    public Fact create(@RequestBody Fact fact) {
        return factService.create(fact);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        factService.delete(id);
    }
}