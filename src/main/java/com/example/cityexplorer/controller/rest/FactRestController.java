package com.example.cityexplorer.controller.rest;

import com.example.cityexplorer.dto.FactDto;
import com.example.cityexplorer.facade.FactFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fact")
public class FactRestController {

    private final FactFacade factFacade;

    public FactRestController(FactFacade factFacade) {
        this.factFacade = factFacade;
    }

    @GetMapping("{id}")
    public FactDto get(@PathVariable Long id) {
        return factFacade.get(id);
    }

    @PostMapping
    public FactDto create(@RequestBody FactDto fact) {
        return factFacade.create(fact);
    }

    @PatchMapping
    public FactDto update(@RequestBody FactDto fact) {
        return factFacade.update(fact);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        factFacade.delete(id);
    }
}