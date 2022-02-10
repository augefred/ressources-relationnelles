package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Utilisateur;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {
    private final UtilisateurRepository userRepository;

    public UtilisateurService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Utilisateur> list() {
        return userRepository.findAll();
    }

    public List<Utilisateur> list(String lastName, String firstName) {
        List<Utilisateur> userList = userRepository.findAll();
        if (lastName != null) {
            userList = userList.stream().filter(user ->
                    user.getUTI_Nom().equals(lastName)).collect(Collectors.toList());
        }
        if (firstName != null) {
            userList = userList.stream().filter(user ->
                    user.getUTI_Prenom().equals(firstName)).collect(Collectors.toList());
        }

        return userList;
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
}
