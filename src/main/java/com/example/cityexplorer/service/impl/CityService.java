package com.example.cityexplorer.service.impl;

import com.example.cityexplorer.model.City;
import com.example.cityexplorer.repository.CityRepository;
import com.example.cityexplorer.service.ICityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.example.cityexplorer.util.ExceptionUtils.createException;

@Service
public class CityService implements ICityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    public City create(City persist) {
        return cityRepository.save(persist);
    }

    @Override
    public City get(Long id) {
        return cityRepository.findById(id).orElseThrow(
                createException(EntityNotFoundException.class, "Entity with id - " + id + " not found"));
    }

    @Override
    @Transactional
    public City update(City updated) {
        throwIfNotExist(updated.getId(), cityRepository);
        return cityRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByNameIgnoreCase(name).orElseThrow(EntityNotFoundException::new);
    }
}