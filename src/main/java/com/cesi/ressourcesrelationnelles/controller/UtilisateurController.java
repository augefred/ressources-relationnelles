package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.Utilisateur;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/utilisateur")
    public List<Utilisateur> getAllUtilisateurs(@RequestParam(required = false) String nom, @RequestParam(required = false) String prenom) {
        if (nom != null || prenom != null) {
            return utilisateurService.list(nom, prenom);
        }
        return utilisateurService.list();
    }

    @GetMapping("/utilisateur/{id}")
    public Utilisateur getUserById(@PathVariable long id) {
        try {
            return utilisateurService.findById(id);
        } catch (NotFoundException e) {
            logger.warn("user {} not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    /*@PostMapping("/utilisateur")
    public UtilisateurDto createUser(@RequestBody Utilisateur utilisateur) {
        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();

        return utilisateurMapper.toDto(utilisateurService.create(utilisateur));
    }

    @DeleteMapping("/utilisateur/{id}")
    public void deleteUserById(@PathVariable long id) {
        utilisateurService.delete(id);
    }

    @PutMapping("/utilisateur/{id}")
    public UtilisateurDto updateUserById(@PathVariable long id, @RequestBody Utilisateur utilisateur) {
        utilisateur.setUTI_ID(id);
        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        return utilisateurMapper.toDto(utilisateurService.update(utilisateur));
    }*/
}