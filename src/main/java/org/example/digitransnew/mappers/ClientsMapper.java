package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.ClientsDto;
import org.example.digitransnew.entities.Clients;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientsMapper {

    ClientsDto toDto(Clients clients);

    Clients toEntity(ClientsDto clientsDto);
}