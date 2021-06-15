package com.example.cityexplorer.facade;

import com.example.cityexplorer.dto.PlaceDto;
import com.example.cityexplorer.mapper.PlaceMapper;
import com.example.cityexplorer.model.Place;
import com.example.cityexplorer.service.IPlaceService;
import org.springframework.stereotype.Component;

@Component
public class PlaceFacade {

    private final IPlaceService service;
    private final PlaceMapper mapper;

    public PlaceFacade(IPlaceService service, PlaceMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public PlaceDto get(Long id) {
        return mapper.toDto(service.get(id));
    }

    public PlaceDto create(PlaceDto dto) {
        final Place created = service.create(mapper.toEntity(dto));
        return mapper.toDto(created);
    }

    public PlaceDto update(PlaceDto dto) {
        final Place updated = service.update(mapper.toEntity(dto));
        return mapper.toDto(updated);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}