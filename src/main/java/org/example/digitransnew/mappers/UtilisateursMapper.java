package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.UtilisateursDto;
import org.example.digitransnew.entities.Utilisateurs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateursMapper {

    UtilisateursDto toDto(Utilisateurs utilisateurs);

    Utilisateurs toEntity(UtilisateursDto utilisateursDto);
}