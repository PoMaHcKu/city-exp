package com.example.cityexplorer.facade;

import com.example.cityexplorer.dto.FactDto;
import com.example.cityexplorer.mapper.FactMapper;
import com.example.cityexplorer.model.Fact;
import com.example.cityexplorer.service.IFactService;
import org.springframework.stereotype.Component;

@Component
public class FactFacade {

    private final IFactService service;
    private final FactMapper mapper;

    public FactFacade(IFactService service, FactMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public FactDto get(Long id) {
        return mapper.toDto(service.get(id));
    }

    public FactDto create(FactDto dto) {
        final Fact created = service.create(mapper.toEntity(dto));
        return mapper.toDto(created);
    }

    public FactDto update(FactDto dto) {
        final Fact updated = service.update(mapper.toEntity(dto));
        return mapper.toDto(updated);
    }

    public void delete(Long id) {
        service.delete(id);
    }
}