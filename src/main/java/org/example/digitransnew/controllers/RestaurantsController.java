package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.digitransnew.dtos.RestaurantsDto;
import org.example.digitransnew.services.interfaces.RestaurantsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@Tag(
        name = "Restaurants",
        description = "API de gestion des restaurants partenaires"
)
public class RestaurantsController {

    private final RestaurantsInterface restaurantsInterface;

    public RestaurantsController(RestaurantsInterface restaurantsInterface) {
        this.restaurantsInterface = restaurantsInterface;
    }

    @Operation(
            summary = "Créer un restaurant",
            description = "Permet d'enregistrer un nouveau restaurant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Restaurant créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public RestaurantsDto save(@RequestBody RestaurantsDto restaurantsDto) {
        return restaurantsInterface.save(restaurantsDto);
    }

    @Operation(
            summary = "Modifier un restaurant",
            description = "Met à jour les informations d'un restaurant existant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Restaurant modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Restaurant introuvable")
    })
    @PutMapping("/{id}")
    public RestaurantsDto update(

            @Parameter(
                    description = "Identifiant du restaurant",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody RestaurantsDto restaurantsDto) {

        return restaurantsInterface.update(id, restaurantsDto);
    }

    @Operation(
            summary = "Rechercher un restaurant",
            description = "Retourne les informations d'un restaurant à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Restaurant trouvé"),
            @ApiResponse(responseCode = "404", description = "Restaurant introuvable")
    })
    @GetMapping("/{id}")
    public RestaurantsDto findById(

            @Parameter(
                    description = "Identifiant du restaurant",
                    example = "1"
            )
            @PathVariable Long id) {

        return restaurantsInterface.findById(id);
    }

    @Operation(
            summary = "Lister tous les restaurants",
            description = "Retourne la liste complète des restaurants."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste des restaurants récupérée avec succès"
    )
    @GetMapping
    public List<RestaurantsDto> findAll() {
        return restaurantsInterface.findAll();
    }

    @Operation(
            summary = "Supprimer un restaurant",
            description = "Supprime un restaurant à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Restaurant supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Restaurant introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant du restaurant",
                    example = "1"
            )
            @PathVariable Long id) {

        restaurantsInterface.delete(id);
    }
}