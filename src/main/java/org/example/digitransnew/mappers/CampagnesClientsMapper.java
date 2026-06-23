package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.CampagnesClientsDto;
import org.example.digitransnew.entities.CampagnesClients;
import org.mapstruct.Mapper;  // CORRIGÉ : Bon import pour le Mapper
import org.mapstruct.Mapping; // CORRIGÉ : Bon import pour le Mapping

@Mapper(componentModel = "spring")
public interface CampagnesClientsMapper {

    @Mapping(source = "campagnesClientsPK.campagneId", target = "campagneId")
    @Mapping(source = "campagnesClientsPK.clientId", target = "clientId")
    CampagnesClientsDto toDto(CampagnesClients campagnesClients);

    @Mapping(source = "campagneId", target = "campagnesClientsPK.campagneId")
    @Mapping(source = "clientId", target = "campagnesClientsPK.clientId")
    CampagnesClients toEntity(CampagnesClientsDto campagnesClientsDto);
}