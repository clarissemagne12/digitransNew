package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.CampagnesDto;
import org.example.digitransnew.entities.Campagnes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CampagnesMapper {

    @Mapping(source = "creePar.id", target = "creeParId")
    CampagnesDto toDto(Campagnes campagnes);

    @Mapping(source = "creeParId", target = "creePar.id")
    Campagnes toEntity(CampagnesDto campagnesDto);
}