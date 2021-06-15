package com.example.cityexplorer.controller.rest;

import com.example.cityexplorer.dto.PlaceDto;
import com.example.cityexplorer.facade.PlaceFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("place")
public class PlaceRestController {

    private final PlaceFacade placeFacade;

    public PlaceRestController(PlaceFacade placeFacade) {
        this.placeFacade = placeFacade;
    }

    @GetMapping("{id}")
    public PlaceDto get(@PathVariable Long id) {
        return placeFacade.get(id);
    }

    @PostMapping
    public PlaceDto create(@RequestBody PlaceDto place) {
        return placeFacade.create(place);
    }

    @PatchMapping
    public PlaceDto update(@RequestBody PlaceDto place) {
        return placeFacade.update(place);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        placeFacade.delete(id);
    }
}