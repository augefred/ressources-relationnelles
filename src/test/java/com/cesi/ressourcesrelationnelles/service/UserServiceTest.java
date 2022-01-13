package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    public UserService userService;


    @Test
    void createUserTest() {
        userService.create(new User());
        List<User> users = userService.list();
        assertEquals(1, users.size());
    }

    @Test
    void findUserByIdTest() throws NotFoundException {
        User user = userService.create(new User());
        User actualUser = userService.findById(user.getId());
        assertNotNull(actualUser);
    }

    @Test
    void findUserByIdNoExistingTest() {
        assertThrowsExactly(NotFoundException.class, () -> {
            User actualUser = userService.findById(-27);
        });
    }
}