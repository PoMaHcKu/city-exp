package com.example.cityexplorer.service.impl;

import com.example.cityexplorer.model.Fact;
import com.example.cityexplorer.repository.FactRepository;
import com.example.cityexplorer.service.IFactService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.util.Objects;

@Service
public class FactService implements IFactService {

    private final FactRepository factRepository;

    public FactService(FactRepository factRepository) {
        this.factRepository = factRepository;
    }

    @Override
    public Fact create(Fact persist) {
        return factRepository.save(persist);
    }

    @Override
    public Fact get(Long id) {
        return factRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Fact update(Fact updated) {
        if (Objects.isNull(updated.getId())) {
            throw new InvalidParameterException("Updated entity must be with id");
        }
        return factRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        factRepository.deleteById(id);
    }
}