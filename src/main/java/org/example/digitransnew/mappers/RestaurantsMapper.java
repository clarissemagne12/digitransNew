package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.RestaurantsDto;
import org.example.digitransnew.entities.Restaurants;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantsMapper {

    RestaurantsDto toDto(Restaurants restaurants);

    Restaurants toEntity(RestaurantsDto restaurantsDto);
}