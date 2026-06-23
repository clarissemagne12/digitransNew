package org.example.digitransnew.repositories;


import org.example.digitransnew.entities.CampagnesClients;
import org.example.digitransnew.entities.CampagnesClientsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagnesClientsRepo extends JpaRepository<CampagnesClients, CampagnesClientsPK> {
}