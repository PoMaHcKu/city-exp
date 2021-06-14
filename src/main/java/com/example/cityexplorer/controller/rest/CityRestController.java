package com.example.cityexplorer.controller.rest;

import com.example.cityexplorer.model.City;
import com.example.cityexplorer.service.ICityService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("city")
public class CityRestController {

    private final ICityService cityService;

    public CityRestController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("{id}")
    public City get(@PathVariable Long id) {
        return cityService.get(id);
    }

    @PostMapping
    public City create(@RequestBody City city) {
       return cityService.create(city);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }
}