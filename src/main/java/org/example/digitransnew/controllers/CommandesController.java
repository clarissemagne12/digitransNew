package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.digitransnew.dtos.CommandesDto;
import org.example.digitransnew.services.interfaces.CommandesInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@Tag(
        name = "Commandes",
        description = "API de gestion des commandes"
)
public class CommandesController {

    private final CommandesInterface commandesInterface;

    public CommandesController(CommandesInterface commandesInterface) {
        this.commandesInterface = commandesInterface;
    }

    @Operation(
            summary = "Créer une commande",
            description = "Permet d'enregistrer une nouvelle commande."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Commande créée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public CommandesDto save(@RequestBody CommandesDto commandesDto) {
        return commandesInterface.save(commandesDto);
    }

    @Operation(
            summary = "Modifier une commande",
            description = "Met à jour les informations d'une commande existante."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Commande modifiée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande introuvable")
    })
    @PutMapping("/{id}")
    public CommandesDto update(

            @Parameter(
                    description = "Identifiant de la commande",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody CommandesDto commandesDto) {

        return commandesInterface.update(id, commandesDto);
    }

    @Operation(
            summary = "Rechercher une commande",
            description = "Retourne les informations d'une commande à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Commande trouvée"),
            @ApiResponse(responseCode = "404", description = "Commande introuvable")
    })
    @GetMapping("/{id}")
    public CommandesDto findById(

            @Parameter(
                    description = "Identifiant de la commande",
                    example = "1"
            )
            @PathVariable Long id) {

        return commandesInterface.findById(id);
    }

    @Operation(
            summary = "Lister toutes les commandes",
            description = "Retourne la liste complète des commandes."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste des commandes récupérée avec succès"
    )
    @GetMapping
    public List<CommandesDto> findAll() {
        return commandesInterface.findAll();
    }

    @Operation(
            summary = "Supprimer une commande",
            description = "Supprime une commande à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Commande supprimée avec succès"),
            @ApiResponse(responseCode = "404", description = "Commande introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant de la commande",
                    example = "1"
            )
            @PathVariable Long id) {

        commandesInterface.delete(id);
    }
}