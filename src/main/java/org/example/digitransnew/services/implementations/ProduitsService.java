package org.example.digitransnew.services.implementations;

import org.example.digitransnew.dtos.ProduitsDto;
import org.example.digitransnew.entities.Produits;
import org.example.digitransnew.exceptions.ApiException;
import org.example.digitransnew.mappers.ProduitsMapper;
import org.example.digitransnew.repositories.ProduitsRepo;
import org.example.digitransnew.services.interfaces.ProduitsInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitsService implements ProduitsInterface {

    private final ProduitsRepo produitsRepo;
    private final ProduitsMapper produitsMapper;

    public ProduitsService(ProduitsRepo produitsRepo,
                           ProduitsMapper produitsMapper) {
        this.produitsRepo = produitsRepo;
        this.produitsMapper = produitsMapper;
    }

    @Override
    public ProduitsDto save(ProduitsDto produitsDto) {

        if (produitsDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de produit invalides");
        }

        Produits produits = produitsMapper.toEntity(produitsDto);

        return produitsMapper.toDto(
                produitsRepo.save(produits)
        );
    }

    @Override
    public ProduitsDto update(Long id, ProduitsDto produitsDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de produit invalide");
        }
        if (!produitsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Produit introuvable");
        }

        Produits produits = produitsMapper.toEntity(produitsDto);

        produits.setId(id);

        return produitsMapper.toDto(
                produitsRepo.save(produits)
        );
    }

    @Override
    public ProduitsDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de produit invalide");
        }

        return produitsRepo.findById(id)
                .map(produitsMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Produit introuvable"));
    }

    @Override
    public List<ProduitsDto> findAll() {

        return produitsRepo.findAll()
                .stream()
                .map(produitsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de produit invalide");
        }
        if (!produitsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Produit introuvable");
        }

        produitsRepo.deleteById(id);
    }
}