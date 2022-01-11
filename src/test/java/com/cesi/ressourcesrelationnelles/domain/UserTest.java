package com.cesi.ressourcesrelationnelles.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {
    @Test
    public void createUser() {
        User user = new User();
        user.setFirstName("fred");
        Assert.notNull(user);
        assertEquals("fred", user.getFirstName());
    }

    @Test
    public void getFullUser() {
        User user = new User();
        user.setFirstName("fred");
        user.setLastName("foo");

        assertNotNull(user);
        assertEquals("fredfoo", user.getFullName());
    }
}
