package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.digitransnew.dtos.LignesCommandesDto;
import org.example.digitransnew.services.interfaces.LignesCommandesInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lignes-commandes")
@Tag(
        name = "Lignes de Commandes",
        description = "API de gestion des lignes de commandes"
)
public class LignesCommandesController {

    private final LignesCommandesInterface lignesCommandesInterface;

    public LignesCommandesController(LignesCommandesInterface lignesCommandesInterface) {
        this.lignesCommandesInterface = lignesCommandesInterface;
    }

    @Operation(
            summary = "Créer une ligne de commande",
            description = "Permet d'ajouter une nouvelle ligne à une commande."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ligne de commande créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public LignesCommandesDto save(@RequestBody LignesCommandesDto dto) {
        return lignesCommandesInterface.save(dto);
    }

    @Operation(
            summary = "Modifier une ligne de commande",
            description = "Met à jour les informations d'une ligne de commande existante."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ligne de commande modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande introuvable")
    })
    @PutMapping("/{id}")
    public LignesCommandesDto update(

            @Parameter(
                    description = "Identifiant de la ligne de commande",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody LignesCommandesDto dto) {

        return lignesCommandesInterface.update(id, dto);
    }

    @Operation(
            summary = "Rechercher une ligne de commande",
            description = "Retourne les informations d'une ligne de commande à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ligne de commande trouvée"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande introuvable")
    })
    @GetMapping("/{id}")
    public LignesCommandesDto findById(

            @Parameter(
                    description = "Identifiant de la ligne de commande",
                    example = "1"
            )
            @PathVariable Long id) {

        return lignesCommandesInterface.findById(id);
    }

    @Operation(
            summary = "Lister toutes les lignes de commandes",
            description = "Retourne la liste complète des lignes de commandes."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste récupérée avec succès"
    )
    @GetMapping
    public List<LignesCommandesDto> findAll() {
        return lignesCommandesInterface.findAll();
    }

    @Operation(
            summary = "Supprimer une ligne de commande",
            description = "Supprime une ligne de commande à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ligne de commande supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Ligne de commande introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant de la ligne de commande",
                    example = "1"
            )
            @PathVariable Long id) {

        lignesCommandesInterface.delete(id);
    }
}