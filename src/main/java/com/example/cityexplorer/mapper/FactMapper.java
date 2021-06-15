package com.example.cityexplorer.mapper;

import com.example.cityexplorer.dto.FactDto;
import com.example.cityexplorer.model.Fact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FactMapper {

    @Mapping(target = "place", source = "entity.place.id")
    FactDto toDto(Fact entity);

    @Mapping(target = "place.id", source = "dto.place")
    Fact toEntity(FactDto dto);

}