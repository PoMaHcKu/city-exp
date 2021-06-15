package com.example.cityexplorer.facade;

import com.example.cityexplorer.dto.CityDto;
import com.example.cityexplorer.mapper.CityMapper;
import com.example.cityexplorer.model.City;
import com.example.cityexplorer.service.ICityService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityFacade {

    private final ICityService service;
    private final CityMapper mapper;

    public CityFacade(ICityService service, CityMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public CityDto get(Long id) {
        return mapper.toDto(service.get(id));
    }

    public List<CityDto> getAll() {
        return service.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CityDto create(CityDto dto) {
        final City created = service.create(mapper.toEntity(dto));
        return mapper.toDto(created);
    }

    public CityDto update(CityDto dto) {
        final City updated = service.update(mapper.toEntity(dto));
        return mapper.toDto(updated);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}