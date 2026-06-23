package org.example.digitransnew.services.interfaces;


import org.example.digitransnew.dtos.UtilisateursDto;
import org.example.digitransnew.entities.Utilisateurs;

import java.util.List;

public interface UtilisateursInterface {

    UtilisateursDto save(UtilisateursDto utilisateursDto);

    UtilisateursDto update(Long id, UtilisateursDto utilisateursDto);

    UtilisateursDto findById(Long id);

    List<UtilisateursDto> findAll();

    void delete(Long id);

    UtilisateursDto saveUtilisateur(UtilisateursDto utilisateursDto);

    void deleteUtilisateur(long l);

    Utilisateurs getUtilisateurById(long l);

    List<Utilisateurs> getAllUtilisateurs();
}