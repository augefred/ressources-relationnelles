package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Ressource;
import com.cesi.ressourcesrelationnelles.domain.Utilisateur;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {
    private final UtilisateurRepository userRepository;

    public UtilisateurService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Utilisateur> list() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Iterable<Utilisateur> iterable = userRepository.findAll();
        for (Utilisateur item : iterable) {
            utilisateurs.add(item);
        }
        return utilisateurs;
    }

    public List<Utilisateur> list(String lastName, String firstName) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Iterable<Utilisateur> iterable = userRepository.findAll();
        for (Utilisateur item : iterable) {
            utilisateurs.add(item);
        }
        if (lastName != null) {
            utilisateurs = utilisateurs.stream().filter(user ->
                    user.getUTI_Nom().equals(lastName)).collect(Collectors.toList());
        }
        if (firstName != null) {
            utilisateurs = utilisateurs.stream().filter(user ->
                    user.getUTI_Prenom().equals(firstName)).collect(Collectors.toList());
        }

        return utilisateurs;
    }

    public Utilisateur create(Utilisateur user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public Utilisateur update(Utilisateur user) {
        return userRepository.save(user);

    }

    public Utilisateur findById(long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found"));
    }

    public Utilisateur findByEmail(String email) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Iterable<Utilisateur> iterable = userRepository.findAll();
        for (Utilisateur item : iterable) {
            if(item.getUTI_Mail().equals(email)){
                return item;
            }
        }
        return null;


        //return userRepository.findAll().orElseThrow(() -> new NotFoundException("user not found"));
    }
}
