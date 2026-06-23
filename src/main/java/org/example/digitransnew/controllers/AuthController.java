package org.example.digitransnew.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.digitransnew.dtos.AuthDto;
import org.example.digitransnew.dtos.RegisterDto;
import org.example.digitransnew.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Tag(
        name = "Authentification",
        description = "API d'authentification et de gestion des comptes utilisateurs"
)
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
            summary = "Connexion utilisateur",
            description = "Authentifie un utilisateur et retourne un token JWT."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Connexion réussie"),
            @ApiResponse(responseCode = "401", description = "Identifiants invalides"),
            @ApiResponse(responseCode = "400", description = "Requête invalide")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto authDto) {

        String token = authService.authenticate(authDto);

        Map<String, String> resp = new HashMap<>();
        resp.put("token", token);

        return ResponseEntity.ok(resp);
    }

    @Operation(
            summary = "Inscription utilisateur",
            description = "Crée un nouveau compte utilisateur et retourne un token JWT."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Inscription réussie"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "409", description = "Utilisateur déjà existant")
    })
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) {

        String token = authService.register(registerDto);

        Map<String, String> resp = new HashMap<>();
        resp.put("token", token);

        return ResponseEntity.ok(resp);
    }
}