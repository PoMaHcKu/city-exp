package com.example.cityexplorer.service;

import com.example.cityexplorer.model.City;

import java.util.List;

public interface ICityService extends CommonService<City, Long> {
    List<City> getAll();

    City findByName(String name);
}