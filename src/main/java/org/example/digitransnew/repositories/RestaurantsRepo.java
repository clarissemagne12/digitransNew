package org.example.digitransnew.repositories;

import org.example.digitransnew.entities.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepo extends JpaRepository<Restaurants, Long> {
}