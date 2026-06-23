package org.example.digitransnew.repositories;

import org.example.digitransnew.entities.Reclamations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationsRepo extends JpaRepository<Reclamations, Long> {
}