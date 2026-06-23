package org.example.digitransnew.repositories;

import org.example.digitransnew.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitsRepo extends JpaRepository<Produits, Long> {
}