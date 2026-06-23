package org.example.digitransnew.repositories;

import org.example.digitransnew.entities.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandesRepo extends JpaRepository<Commandes, Long> {
}