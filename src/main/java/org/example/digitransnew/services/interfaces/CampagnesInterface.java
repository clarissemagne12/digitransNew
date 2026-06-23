package org.example.digitransnew.services.interfaces;


import org.example.digitransnew.dtos.CampagnesDto;

import java.util.List;

public interface CampagnesInterface {

    CampagnesDto save(CampagnesDto campagnesDto);

    CampagnesDto update(Long id, CampagnesDto campagnesDto);

    CampagnesDto findById(Long id);

    List<CampagnesDto> findAll();

    void delete(Long id);
}