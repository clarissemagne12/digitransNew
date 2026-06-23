package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.digitransnew.dtos.UtilisateursDto;
import org.example.digitransnew.services.interfaces.UtilisateursInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@Tag(
        name = "Utilisateurs",
        description = "API de gestion des utilisateurs de l'application"
)
public class UtilisateursController {

    private final UtilisateursInterface utilisateursInterface;

    public UtilisateursController(UtilisateursInterface utilisateursInterface) {
        this.utilisateursInterface = utilisateursInterface;
    }

    @Operation(
            summary = "Créer un utilisateur",
            description = "Permet d'enregistrer un nouvel utilisateur."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Utilisateur créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public UtilisateursDto save(@RequestBody UtilisateursDto utilisateursDto) {
        return utilisateursInterface.save(utilisateursDto);
    }

    @Operation(
            summary = "Modifier un utilisateur",
            description = "Met à jour les informations d'un utilisateur existant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Utilisateur modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur introuvable")
    })
    @PutMapping("/{id}")
    public UtilisateursDto update(

            @Parameter(
                    description = "Identifiant de l'utilisateur",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody UtilisateursDto utilisateursDto) {

        return utilisateursInterface.update(id, utilisateursDto);
    }

    @Operation(
            summary = "Rechercher un utilisateur",
            description = "Retourne les informations d'un utilisateur à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Utilisateur trouvé"),
            @ApiResponse(responseCode = "404", description = "Utilisateur introuvable")
    })
    @GetMapping("/{id}")
    public UtilisateursDto findById(

            @Parameter(
                    description = "Identifiant de l'utilisateur",
                    example = "1"
            )
            @PathVariable Long id) {

        return utilisateursInterface.findById(id);
    }

    @Operation(
            summary = "Lister tous les utilisateurs",
            description = "Retourne la liste complète des utilisateurs."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste des utilisateurs récupérée avec succès"
    )
    @GetMapping
    public List<UtilisateursDto> findAll() {
        return utilisateursInterface.findAll();
    }

    @Operation(
            summary = "Supprimer un utilisateur",
            description = "Supprime un utilisateur à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Utilisateur supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Utilisateur introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant de l'utilisateur",
                    example = "1"
            )
            @PathVariable Long id) {

        utilisateursInterface.delete(id);
    }
}