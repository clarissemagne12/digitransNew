package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.LignesCommandesDto;
import org.example.digitransnew.entities.LignesCommandes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LignesCommandesMapper {

    @Mapping(source = "commandeId.id", target = "commandeId")
    @Mapping(source = "produitId.id", target = "produitId")
    LignesCommandesDto toDto(LignesCommandes lignesCommandes);

    @Mapping(source = "commandeId", target = "commandeId.id")
    @Mapping(source = "produitId", target = "produitId.id")
    LignesCommandes toEntity(LignesCommandesDto lignesCommandesDto);
}