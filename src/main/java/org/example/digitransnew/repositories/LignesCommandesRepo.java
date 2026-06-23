package org.example.digitransnew.repositories;

import org.example.digitransnew.entities.LignesCommandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignesCommandesRepo extends JpaRepository<LignesCommandes, Long> {
}