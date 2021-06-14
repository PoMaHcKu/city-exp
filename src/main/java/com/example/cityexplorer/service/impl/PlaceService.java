package com.example.cityexplorer.service.impl;

import com.example.cityexplorer.model.Place;
import com.example.cityexplorer.repository.PlaceRepository;
import com.example.cityexplorer.service.IPlaceService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class PlaceService implements IPlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place create(Place persist) {
        return placeRepository.save(persist);
    }

    @Override
    public Place get(Long id) {
        return placeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Place update(Place updated) {
        //todo
        return null;
    }

    @Override
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }
}