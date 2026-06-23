package org.example.digitransnew.services.interfaces;


import org.example.digitransnew.dtos.RestaurantsDto;
import org.example.digitransnew.entities.Restaurants;

import java.util.List;

public interface RestaurantsInterface {

    RestaurantsDto save(RestaurantsDto restaurantsDto);

    RestaurantsDto update(Long id, RestaurantsDto restaurantsDto);

    RestaurantsDto findById(Long id);

    List<RestaurantsDto> findAll();

    void delete(Long id);

    RestaurantsDto saveRestaurant(RestaurantsDto restaurantsDto);

    void deleteRestaurant(long l);

    List<Restaurants> getAllRestaurants();

    Restaurants getRestaurantById(long l);
}