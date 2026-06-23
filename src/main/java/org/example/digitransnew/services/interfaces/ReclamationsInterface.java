package org.example.digitransnew.services.interfaces;

import org.example.digitransnew.dtos.ReclamationsDto;

import java.util.List;

public interface ReclamationsInterface {

    ReclamationsDto save(ReclamationsDto reclamationsDto);

    ReclamationsDto update(Long id, ReclamationsDto reclamationsDto);

    ReclamationsDto findById(Long id);

    List<ReclamationsDto> findAll();

    void delete(Long id);
}