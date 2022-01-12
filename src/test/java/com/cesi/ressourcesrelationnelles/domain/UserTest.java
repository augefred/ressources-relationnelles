package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserTest {
    @Test
    void createUser() {
        User user = new User();
        user.setFirstName("fred");
        assertNotNull(user);
        assertEquals("fred", user.getFirstName());
    }

    @Test
    void getFullUser() {
        User user = new User();
        user.setFirstName("fred");
        user.setLastName("foo");

        assertNotNull(user);

    }
}
