package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.Utilisateur;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.UtilisateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    public UtilisateurService userService;

    @Autowired
    public UtilisateurRepository userRepository;

    @Test
    void createUserTest() {
        userRepository.deleteAll();

        userService.create(new Utilisateur());
        List<Utilisateur> users = userService.list();
        assertEquals(1, users.size());
    }

    @Test
    void findUserByIdTest() throws NotFoundException {
        userRepository.deleteAll();

        Utilisateur user = userService.create(new Utilisateur());
        Utilisateur actualUser = userService.findById(user.getUTI_ID());
        assertNotNull(actualUser);
    }

    @Test
    void findUserByIdNoExistingTest() {
        userRepository.deleteAll();

        assertThrowsExactly(NotFoundException.class, () -> {
            Utilisateur actualUser = userService.findById(-27);
        });
    }

    @Test
    void findUsersByNameTest() {
        // Given
        userRepository.deleteAll();

        userService.create(new Utilisateur("fred", "auge"));
        userService.create(new Utilisateur("fred", "foo"));
        // when
        List<Utilisateur> users = userService.list("foo", null);
        assertNotNull(users);
        //Then
        assertEquals(1, users.size());
        assertEquals("foo", users.get(0).getUTI_Nom());
    }

    @Test
    void findUsersByNameNoResultTest() {
        // Given
        userRepository.deleteAll();

        userService.create(new Utilisateur("fred", "auge"));
        userService.create(new Utilisateur("fred", "foo"));
        // when
        List<Utilisateur> users = userService.list("bar", "");
        assertNotNull(users);
        //Then
        assertEquals(0, users.size());
    }

    @Test
    void findUsersByLastNameAndFirstNameTest() {
        // Given
        userRepository.deleteAll();

        userService.create(new Utilisateur("fred", "auge"));
        userService.create(new Utilisateur("fred", "foo"));
        // when
        List<Utilisateur> users = userService.list("foo", "fred");
        assertNotNull(users);
        //Then
        assertEquals(1, users.size());
        assertEquals("foo", users.get(0).getUTI_Nom());
        assertEquals("fred", users.get(0).getUTI_Prenom());
    }
}