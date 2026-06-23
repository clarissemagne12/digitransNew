package org.example.digitransnew.mappers;

import org.example.digitransnew.dtos.ProduitsDto;
import org.example.digitransnew.entities.Produits;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitsMapper {

    ProduitsDto toDto(Produits produits);

    Produits toEntity(ProduitsDto produitsDto);
}