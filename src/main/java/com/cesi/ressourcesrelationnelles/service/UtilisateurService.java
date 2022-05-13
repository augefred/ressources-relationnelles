package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {
    private final UtilisateurRepository userRepository;

    public UtilisateurService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        List<User> utilisateurs = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        for (User item : iterable) {
            utilisateurs.add(item);
        }
        return utilisateurs;
    }

    public List<User> list(String lastName, String firstName) {
        List<User> utilisateurs = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        for (User item : iterable) {
            utilisateurs.add(item);
        }
        if (lastName != null) {
            utilisateurs = utilisateurs.stream().filter(user ->
                    user.getLastName().equals(lastName)).collect(Collectors.toList());
        }
        if (firstName != null) {
            utilisateurs = utilisateurs.stream().filter(user ->
                    user.getFirstName().equals(firstName)).collect(Collectors.toList());
        }

        return utilisateurs;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        return userRepository.save(user);

    }

    public User findById(long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found"));
    }

    public User findByEmail(String email) {
        List<User> utilisateurs = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        for (User item : iterable) {
            if(item.getEmail().equals(email)){
                return item;
            }
        }
        return null;


        //return userRepository.findAll().orElseThrow(() -> new NotFoundException("user not found"));
    }
}
