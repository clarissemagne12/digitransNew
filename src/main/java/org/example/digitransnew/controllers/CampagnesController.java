package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.digitransnew.dtos.CampagnesDto;
import org.example.digitransnew.services.interfaces.CampagnesInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes")
@Tag(
        name = "Campagnes",
        description = "API de gestion des campagnes marketing"
)
public class CampagnesController {

    private final CampagnesInterface campagnesInterface;

    public CampagnesController(CampagnesInterface campagnesInterface) {
        this.campagnesInterface = campagnesInterface;
    }

    @Operation(
            summary = "Créer une campagne",
            description = "Permet de créer une nouvelle campagne."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Campagne créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public CampagnesDto save(@RequestBody CampagnesDto dto) {
        return campagnesInterface.save(dto);
    }

    @Operation(
            summary = "Modifier une campagne",
            description = "Met à jour les informations d'une campagne existante."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Campagne modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Campagne introuvable")
    })
    @PutMapping("/{id}")
    public CampagnesDto update(

            @Parameter(
                    description = "Identifiant de la campagne",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody CampagnesDto dto) {

        return campagnesInterface.update(id, dto);
    }

    @Operation(
            summary = "Rechercher une campagne",
            description = "Retourne les informations d'une campagne à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Campagne trouvée"),
            @ApiResponse(responseCode = "404", description = "Campagne introuvable")
    })
    @GetMapping("/{id}")
    public CampagnesDto findById(

            @Parameter(
                    description = "Identifiant de la campagne",
                    example = "1"
            )
            @PathVariable Long id) {

        return campagnesInterface.findById(id);
    }

    @Operation(
            summary = "Lister toutes les campagnes",
            description = "Retourne la liste complète des campagnes."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste des campagnes récupérée avec succès"
    )
    @GetMapping
    public List<CampagnesDto> findAll() {
        return campagnesInterface.findAll();
    }

    @Operation(
            summary = "Supprimer une campagne",
            description = "Supprime une campagne à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Campagne supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Campagne introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant de la campagne",
                    example = "1"
            )
            @PathVariable Long id) {

        campagnesInterface.delete(id);
    }
}