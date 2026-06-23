package org.example.digitransnew.services.implementations;

import org.example.digitransnew.dtos.ReclamationsDto;
import org.example.digitransnew.entities.Reclamations;
import org.example.digitransnew.exceptions.ApiException;
import org.example.digitransnew.mappers.ReclamationsMapper;
import org.example.digitransnew.repositories.ReclamationsRepo;
import org.example.digitransnew.services.interfaces.ReclamationsInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReclamationsService implements ReclamationsInterface {

    private final ReclamationsRepo reclamationsRepo;
    private final ReclamationsMapper reclamationsMapper;

    public ReclamationsService(ReclamationsRepo reclamationsRepo,
                               ReclamationsMapper reclamationsMapper) {
        this.reclamationsRepo = reclamationsRepo;
        this.reclamationsMapper = reclamationsMapper;
    }

    @Override
    public ReclamationsDto save(ReclamationsDto reclamationsDto) {

        if (reclamationsDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de réclamation invalides");
        }

        Reclamations reclamations = reclamationsMapper.toEntity(reclamationsDto);

        return reclamationsMapper.toDto(
                reclamationsRepo.save(reclamations)
        );
    }

    @Override
    public ReclamationsDto update(Long id, ReclamationsDto reclamationsDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de réclamation invalide");
        }
        if (!reclamationsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Réclamation introuvable");
        }

        Reclamations reclamations = reclamationsMapper.toEntity(reclamationsDto);

        reclamations.setId(id);

        return reclamationsMapper.toDto(
                reclamationsRepo.save(reclamations)
        );
    }

    @Override
    public ReclamationsDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de réclamation invalide");
        }

        return reclamationsRepo.findById(id)
                .map(reclamationsMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Réclamation introuvable"));
    }

    @Override
    public List<ReclamationsDto> findAll() {

        return reclamationsRepo.findAll()
                .stream()
                .map(reclamationsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de réclamation invalide");
        }
        if (!reclamationsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Réclamation introuvable");
        }

        reclamationsRepo.deleteById(id);
    }
}