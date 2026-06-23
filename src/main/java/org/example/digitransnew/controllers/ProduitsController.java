package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.digitransnew.dtos.ProduitsDto;
import org.example.digitransnew.services.interfaces.ProduitsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@Tag(
        name = "Produits",
        description = "API de gestion des produits"
)
public class ProduitsController {

    private final ProduitsInterface produitsInterface;

    public ProduitsController(ProduitsInterface produitsInterface) {
        this.produitsInterface = produitsInterface;
    }

    @Operation(
            summary = "Créer un produit",
            description = "Permet d'ajouter un nouveau produit au catalogue."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit créé avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    public ProduitsDto save(@RequestBody ProduitsDto produitsDto) {
        return produitsInterface.save(produitsDto);
    }

    @Operation(
            summary = "Modifier un produit",
            description = "Met à jour les informations d'un produit existant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit modifié avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit introuvable")
    })
    @PutMapping("/{id}")
    public ProduitsDto update(

            @Parameter(
                    description = "Identifiant du produit",
                    example = "1"
            )
            @PathVariable Long id,

            @RequestBody ProduitsDto produitsDto) {

        return produitsInterface.update(id, produitsDto);
    }

    @Operation(
            summary = "Rechercher un produit",
            description = "Retourne les informations d'un produit à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit trouvé"),
            @ApiResponse(responseCode = "404", description = "Produit introuvable")
    })
    @GetMapping("/{id}")
    public ProduitsDto findById(

            @Parameter(
                    description = "Identifiant du produit",
                    example = "1"
            )
            @PathVariable Long id) {

        return produitsInterface.findById(id);
    }

    @Operation(
            summary = "Lister tous les produits",
            description = "Retourne la liste complète des produits."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Liste des produits récupérée avec succès"
    )
    @GetMapping
    public List<ProduitsDto> findAll() {
        return produitsInterface.findAll();
    }

    @Operation(
            summary = "Supprimer un produit",
            description = "Supprime un produit à partir de son identifiant."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produit supprimé avec succès"),
            @ApiResponse(responseCode = "404", description = "Produit introuvable")
    })
    @DeleteMapping("/{id}")
    public void delete(

            @Parameter(
                    description = "Identifiant du produit",
                    example = "1"
            )
            @PathVariable Long id) {

        produitsInterface.delete(id);
    }
}