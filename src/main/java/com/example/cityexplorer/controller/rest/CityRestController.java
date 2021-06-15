package com.example.cityexplorer.controller.rest;

import com.example.cityexplorer.dto.CityDto;
import com.example.cityexplorer.facade.CityFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityRestController {

    private final CityFacade cityFacade;

    public CityRestController(CityFacade cityFacade) {
        this.cityFacade = cityFacade;
    }

    @GetMapping("{id}")
    public CityDto get(@PathVariable Long id) {
        return cityFacade.get(id);
    }

    @GetMapping
    public List<CityDto> getAll() {
        return cityFacade.getAll();
    }

    @PostMapping
    public CityDto create(@RequestBody CityDto city) {
        return cityFacade.create(city);
    }

    @PatchMapping
    public CityDto update(@RequestBody CityDto city) {
        return cityFacade.update(city);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        cityFacade.delete(id);
    }
}