package com.example.cityexplorer.service.impl;

import com.example.cityexplorer.model.Place;
import com.example.cityexplorer.repository.PlaceRepository;
import com.example.cityexplorer.service.IPlaceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.function.Supplier;

import static com.example.cityexplorer.util.ExceptionUtils.createException;

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
        return placeRepository.findById(id)
                .orElseThrow(createException(EntityNotFoundException.class, "Not found"));
    }

    @Override
    public Place update(Place updated) {
        throwIfNotExist(updated.getId(), placeRepository);
        return placeRepository.save(updated);
    }

    @Override
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }
}