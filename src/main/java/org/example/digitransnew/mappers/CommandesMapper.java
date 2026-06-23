package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.CommandesDto;
import org.example.digitransnew.entities.Commandes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommandesMapper {

    @Mapping(source = "clientId.id", target = "clientId")
    @Mapping(source = "restaurantId.id", target = "restaurantId")
    @Mapping(source = "traitePar.id", target = "traiteParId")
    CommandesDto toDto(Commandes commandes);

    @Mapping(source = "clientId", target = "clientId.id")
    @Mapping(source = "restaurantId", target = "restaurantId.id")
    @Mapping(source = "traiteParId", target = "traitePar.id")
    Commandes toEntity(CommandesDto commandesDto);
}