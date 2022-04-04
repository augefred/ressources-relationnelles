package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {
    @Test
    void createUser() {
        Utilisateur user = new Utilisateur();
        user.setUTI_Prenom("fred");
        assertNotNull(user);
        assertEquals("fred", user.getUTI_Prenom());
    }

    @Test
    void getFullUser() {
        Utilisateur user = new Utilisateur();
        user.setUTI_Prenom("fred");
        user.setUTI_Prenom("foo");

        assertNotNull(user);

    }
}
