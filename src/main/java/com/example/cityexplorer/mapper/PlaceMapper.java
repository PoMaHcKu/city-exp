package com.example.cityexplorer.mapper;

import com.example.cityexplorer.dto.PlaceDto;
import com.example.cityexplorer.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    @Mapping(target = "city", source = "entity.city.id")
    PlaceDto toDto(Place entity);

    @Mapping(target = "city.id", source = "dto.city")
    Place toEntity(PlaceDto dto);

}