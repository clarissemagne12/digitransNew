package org.example.digitransnew.services.interfaces;


import org.example.digitransnew.dtos.LignesCommandesDto;

import java.util.List;

public interface LignesCommandesInterface {

    LignesCommandesDto save(LignesCommandesDto lignesCommandesDto);

    LignesCommandesDto update(Long id, LignesCommandesDto lignesCommandesDto);

    LignesCommandesDto findById(Long id);

    List<LignesCommandesDto> findAll();

    void delete(Long id);
}