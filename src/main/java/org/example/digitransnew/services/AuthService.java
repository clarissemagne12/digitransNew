package org.example.digitransnew.services;

import org.example.digitransnew.dtos.AuthDto;
import org.example.digitransnew.dtos.RegisterDto;
import org.example.digitransnew.entities.Utilisateurs;
import org.example.digitransnew.exceptions.ApiException;
import org.example.digitransnew.repositories.UtilisateursRepo;
import org.example.digitransnew.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final UtilisateursRepo utilisateursRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService, UtilisateursRepo utilisateursRepo, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.utilisateursRepo = utilisateursRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public String authenticate(AuthDto authDto) {
        // Vérifie les identifiants et retourne un token JWT si l'authentification réussit.
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getMotDePasse()));
        } catch (AuthenticationException ex) {
            throw new ApiException(HttpStatus.UNAUTHORIZED, "Identifiants invalides");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authDto.getEmail());
        if (userDetails == null) {
            throw new ApiException(HttpStatus.UNAUTHORIZED, "Utilisateur introuvable");
        }
        // Génère un token JWT pour l'utilisateur authentifié
        return jwtUtil.generateToken(userDetails);
    }

    public String register(RegisterDto registerDto) {
        // Crée un nouvel utilisateur et retourne son jeton JWT
        if (utilisateursRepo.findByEmail(registerDto.getEmail()).isPresent()) {
                throw new ApiException(HttpStatus.BAD_REQUEST, "L'adresse email est déjà utilisée");
        }

        Utilisateurs utilisateur = new Utilisateurs();
        utilisateur.setNom(registerDto.getNom());
        utilisateur.setPrenom(registerDto.getPrenom());
        utilisateur.setEmail(registerDto.getEmail());
        utilisateur.setMotDePasse(passwordEncoder.encode(registerDto.getMotDePasse()));
        utilisateur.setRole(registerDto.getRole() != null && !registerDto.getRole().isBlank() ? registerDto.getRole() : "ROLE_USER");
        utilisateur.setActif(true);
        utilisateur.setDateCreation(new java.util.Date());

        utilisateursRepo.save(utilisateur);
        UserDetails userDetails = userDetailsService.loadUserByUsername(registerDto.getEmail());
        return jwtUtil.generateToken(userDetails);
    }
}
