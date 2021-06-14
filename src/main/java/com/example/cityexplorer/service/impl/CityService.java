package com.example.cityexplorer.service.impl;

import com.example.cityexplorer.model.City;
import com.example.cityexplorer.repository.CityRepository;
import com.example.cityexplorer.service.ICityService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
public class CityService implements ICityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(City persist) {
        return cityRepository.save(persist);
    }

    @Override
    public City get(Long id) {
        return cityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public City update(City updated) {
        //todo
        return cityRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}