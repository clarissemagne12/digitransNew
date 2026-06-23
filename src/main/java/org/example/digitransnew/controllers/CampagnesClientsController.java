package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.digitransnew.dtos.CampagnesClientsDto;
import org.example.digitransnew.services.interfaces.CampagnesClientsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes-clients")
@Tag(
        name = "Campagnes-Clients",
        description = "API de gestion des associations entre les campagnes et les clients"
)
public class CampagnesClientsController {

    private final CampagnesClientsInterface campagnesClientsInterface;

    public CampagnesClientsController(CampagnesClientsInterface campagnesClientsInterface) {
        this.campagnesClientsInterface = campagnesClientsInterface;
    }

    @Operation(
            summary = "Créer une association campagne-client",
            description = "Permet d'associer un client à une campagne."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Association créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public CampagnesClientsDto save(
            @RequestBody CampagnesClientsDto dto) {
        return campagnesClientsInterface.save(dto);
    }

    @Operation(
            summary = "Rechercher une association",
            description = "Recherche une association entre une campagne et un client à partir de leurs identifiants."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Association trouvée"),
            @ApiResponse(responseCode = "404", description = "Association introuvable")
    })
    @GetMapping("/{campagneId}/{clientId}")
    public CampagnesClientsDto findById(

            @Parameter(
                    description = "Identifiant de la campagne",
                    example = "1"
            )
            @PathVariable Long campagneId,

            @Parameter(
                    description = "Identifiant du client",
                    example = "10"
            )
            @PathVariable Long clientId) {

        return campagnesClientsInterface.findById(campagneId, clientId);
    }

    @Operation(
            summary = "Lister toutes les associations",
            description = "Retourne la liste complète des associations campagne-client."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste récupérée avec succès"
    )
    @GetMapping
    public List<CampagnesClientsDto> findAll() {
        return campagnesClientsInterface.findAll();
    }

    @Operation(
            summary = "Supprimer une association",
            description = "Supprime une association campagne-client existante."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Association supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Association introuvable")
    })
    @DeleteMapping("/{campagneId}/{clientId}")
    public void delete(

            @Parameter(
                    description = "Identifiant de la campagne",
                    example = "1"
            )
            @PathVariable Long campagneId,

            @Parameter(
                    description = "Identifiant du client",
                    example = "10"
            )
            @PathVariable Long clientId) {

        campagnesClientsInterface.delete(campagneId, clientId);
    }
}