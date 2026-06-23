package org.example.digitransnew.repositories;

import org.example.digitransnew.entities.Campagnes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagnesRepo extends JpaRepository<Campagnes, Long> {
}