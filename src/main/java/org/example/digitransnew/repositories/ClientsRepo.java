package org.example.digitransnew.repositories;

import org.example.digitransnew.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepo extends JpaRepository<Clients, Long> {
}