package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.digitransnew.dtos.ClientsDto;
import org.example.digitransnew.services.interfaces.ClientsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(
        name = "Clients",
        description = "API de gestion des clients"
)
public class ClientsController {

    private final ClientsInterface clientsInterface;

    public ClientsController(ClientsInterface clientsInterface) {
        this.clientsInterface = clientsInterface;
    }

    @Operation(
            summary = "Créer un client",
            description = "Permet d'enregistrer un nouveau client."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ClientsDto save(@RequestBody ClientsDto clientsDto) {
        return clientsInterface.save(clientsDto);
    }

    @Operation(
            summary = "Modifier un client",
            description = "Met à jour les informations d'un client existant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    @PutMapping("/{id}")
    public ClientsDto update(

            @Parameter(
                    description = "Identifiant du client",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody ClientsDto clientsDto) {

        return clientsInterface.update(id, clientsDto);
    }

    @Operation(
            summary = "Rechercher un client",
            description = "Retourne les informations d'un client à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    @GetMapping("/{id}")
    public ClientsDto findById(

            @Parameter(
                    description = "Identifiant du client",
                    example = "1"
            )
            @PathVariable Long id) {

        return clientsInterface.findById(id);
    }

    @Operation(
            summary = "Lister tous les clients",
            description = "Retourne la liste complète des clients."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste des clients récupérée avec succès"
    )
    @GetMapping
    public List<ClientsDto> findAll() {
        return clientsInterface.findAll();
    }

    @Operation(
            summary = "Supprimer un client",
            description = "Supprime un client à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant du client",
                    example = "1"
            )
            @PathVariable Long id) {

        clientsInterface.delete(id);
    }
}