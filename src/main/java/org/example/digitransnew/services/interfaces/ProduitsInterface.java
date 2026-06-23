package org.example.digitransnew.services.interfaces;

import org.example.digitransnew.dtos.ProduitsDto;

import java.util.List;
public interface ProduitsInterface {

    ProduitsDto save(ProduitsDto produitsDto);

    ProduitsDto update(Long id, ProduitsDto produitsDto);

    ProduitsDto findById(Long id);

    List<ProduitsDto> findAll();
    
    void delete(Long id);
}
