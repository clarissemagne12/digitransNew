package org.example.digitransnew.services.implementations;

import org.example.digitransnew.dtos.UtilisateursDto;
import org.example.digitransnew.entities.Utilisateurs;
import org.example.digitransnew.exceptions.ApiException;
import org.example.digitransnew.mappers.UtilisateursMapper;
import org.example.digitransnew.repositories.UtilisateursRepo;
import org.example.digitransnew.services.interfaces.UtilisateursInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateursService implements UtilisateursInterface {

    private final UtilisateursRepo utilisateursRepo;
    private final UtilisateursMapper utilisateursMapper;

    public UtilisateursService(UtilisateursRepo utilisateursRepo,
                               UtilisateursMapper utilisateursMapper) {
        this.utilisateursRepo = utilisateursRepo;
        this.utilisateursMapper = utilisateursMapper;
    }

    @Override
    public UtilisateursDto save(UtilisateursDto utilisateursDto) {

        if (utilisateursDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données d'utilisateur invalides");
        }

        Utilisateurs utilisateurs = utilisateursMapper.toEntity(utilisateursDto);

        return utilisateursMapper.toDto(
                utilisateursRepo.save(utilisateurs)
        );
    }

    @Override
    public UtilisateursDto update(Long id, UtilisateursDto utilisateursDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant d'utilisateur invalide");
        }
        if (!utilisateursRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Utilisateur introuvable");
        }

        Utilisateurs utilisateurs = utilisateursMapper.toEntity(utilisateursDto);

        utilisateurs.setId(id);

        return utilisateursMapper.toDto(
                utilisateursRepo.save(utilisateurs)
        );
    }

    @Override
    public UtilisateursDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant d'utilisateur invalide");
        }

        return utilisateursRepo.findById(id)
                .map(utilisateursMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Utilisateur introuvable"));
    }

    @Override
    public List<UtilisateursDto> findAll() {

        return utilisateursRepo.findAll()
                .stream()
                .map(utilisateursMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant d'utilisateur invalide");
        }
        if (!utilisateursRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Utilisateur introuvable");
        }

        utilisateursRepo.deleteById(id);
    }
    @Override
    public UtilisateursDto saveUtilisateur(UtilisateursDto utilisateursDto) {
        return save(utilisateursDto);
    }

    @Override
    public void deleteUtilisateur(long l) {
        delete(l);
    }

    @Override
    public Utilisateurs getUtilisateurById(long l) {
        return utilisateursRepo.findById(l)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Utilisateur introuvable"));
    }

    @Override
    public java.util.List<Utilisateurs> getAllUtilisateurs() {
        return utilisateursRepo.findAll();
    }
}