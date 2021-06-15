package com.example.cityexplorer.mapper;

import com.example.cityexplorer.dto.CityDto;
import com.example.cityexplorer.model.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityDto toDto(City entity);

    City toEntity(CityDto dto);

}