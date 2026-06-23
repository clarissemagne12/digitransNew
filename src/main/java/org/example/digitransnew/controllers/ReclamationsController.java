package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.digitransnew.dtos.ReclamationsDto;
import org.example.digitransnew.services.interfaces.ReclamationsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
@Tag(
        name = "Réclamations",
        description = "API de gestion des réclamations clients"
)
public class ReclamationsController {

    private final ReclamationsInterface reclamationsInterface;

    public ReclamationsController(ReclamationsInterface reclamationsInterface) {
        this.reclamationsInterface = reclamationsInterface;
    }

    @Operation(
            summary = "Créer une réclamation",
            description = "Permet d'enregistrer une nouvelle réclamation."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Réclamation créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ReclamationsDto save(@RequestBody ReclamationsDto reclamationsDto) {
        return reclamationsInterface.save(reclamationsDto);
    }

    @Operation(
            summary = "Modifier une réclamation",
            description = "Met à jour les informations d'une réclamation existante."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Réclamation modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Réclamation introuvable")
    })
    @PutMapping("/{id}")
    public ReclamationsDto update(

            @Parameter(
                    description = "Identifiant de la réclamation",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody ReclamationsDto reclamationsDto) {

        return reclamationsInterface.update(id, reclamationsDto);
    }

    @Operation(
            summary = "Rechercher une réclamation",
            description = "Retourne les informations d'une réclamation à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Réclamation trouvée"),
            @ApiResponse(responseCode = "404", description = "Réclamation introuvable")
    })
    @GetMapping("/{id}")
    public ReclamationsDto findById(

            @Parameter(
                    description = "Identifiant de la réclamation",
                    example = "1"
            )
            @PathVariable Long id) {

        return reclamationsInterface.findById(id);
    }

    @Operation(
            summary = "Lister toutes les réclamations",
            description = "Retourne la liste complète des réclamations."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste des réclamations récupérée avec succès"
    )
    @GetMapping
    public List<ReclamationsDto> findAll() {
        return reclamationsInterface.findAll();
    }

    @Operation(
            summary = "Supprimer une réclamation",
            description = "Supprime une réclamation à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Réclamation supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Réclamation introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant de la réclamation",
                    example = "1"
            )
            @PathVariable Long id) {

        reclamationsInterface.delete(id);
    }
}