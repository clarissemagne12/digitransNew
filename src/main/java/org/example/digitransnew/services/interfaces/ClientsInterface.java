package org.example.digitransnew.services.interfaces;


import org.example.digitransnew.dtos.ClientsDto;

import java.util.List;

public interface ClientsInterface {

    ClientsDto save(ClientsDto clientsDto);

    ClientsDto update(Long id, ClientsDto clientsDto);

    ClientsDto findById(Long id);

    List<ClientsDto> findAll();

    void delete(Long id);
}