package com.example.cityexplorer.controller.rest;

import com.example.cityexplorer.model.Place;
import com.example.cityexplorer.service.IPlaceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("place")
public class PlaceRestController {

    private final IPlaceService placeService;

    public PlaceRestController(IPlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("{id}")
    public Place get(@PathVariable Long id) {
        return placeService.get(id);
    }

    @PostMapping
    public Place create(@RequestBody Place city) {
        return placeService.create(city);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        placeService.delete(id);
    }
}