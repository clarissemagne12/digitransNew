package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.digitransnew.repositories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@Tag(
        name = "Dashboard",
        description = "API de consultation des statistiques du tableau de bord"
)
public class DashboardController {

    private final ClientsRepo clientsRepo;
    private final CommandesRepo commandesRepo;
    private final ProduitsRepo produitsRepo;
    private final ReclamationsRepo reclamationsRepo;
    private final CampagnesRepo campagnesRepo;
    private final UtilisateursRepo utilisateursRepo;
    private final RestaurantsRepo restaurantsRepo;

    public DashboardController(
            ClientsRepo clientsRepo,
            CommandesRepo commandesRepo,
            ProduitsRepo produitsRepo,
            ReclamationsRepo reclamationsRepo,
            CampagnesRepo campagnesRepo,
            UtilisateursRepo utilisateursRepo,
            RestaurantsRepo restaurantsRepo) {
        this.clientsRepo = clientsRepo;
        this.commandesRepo = commandesRepo;
        this.produitsRepo = produitsRepo;
        this.reclamationsRepo = reclamationsRepo;
        this.campagnesRepo = campagnesRepo;
        this.utilisateursRepo = utilisateursRepo;
        this.restaurantsRepo = restaurantsRepo;
    }

    @Operation(
            summary = "Obtenir les statistiques du dashboard",
            description = "Retourne le nombre total de clients, commandes, produits, réclamations, campagnes, utilisateurs et restaurants."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Statistiques récupérées avec succès"
            )
    })
    @GetMapping("/stats")
    public Map<String, Long> getStats() {

        Map<String, Long> stats = new HashMap<>();

        stats.put("clients", clientsRepo.count());
        stats.put("commandes", commandesRepo.count());
        stats.put("produits", produitsRepo.count());
        stats.put("reclamations", reclamationsRepo.count());
        stats.put("campagnes", campagnesRepo.count());
        stats.put("utilisateurs", utilisateursRepo.count());
        stats.put("restaurants", restaurantsRepo.count());

        return stats;
    }
}