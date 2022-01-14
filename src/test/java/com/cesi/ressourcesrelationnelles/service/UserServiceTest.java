package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

    @Test
    void createUserTest() {
        userRepository.deleteAll();

        userService.create(new User());
        List<User> users = userService.list();
        assertEquals(1, users.size());
    }

    @Test
    void findUserByIdTest() throws NotFoundException {
        userRepository.deleteAll();

        User user = userService.create(new User());
        User actualUser = userService.findById(user.getId());
        assertNotNull(actualUser);
    }

    @Test
    void findUserByIdNoExistingTest() {
        userRepository.deleteAll();

        assertThrowsExactly(NotFoundException.class, () -> {
            User actualUser = userService.findById(-27);
        });
    }

    @Test
    void findUsersByNameTest() {
        // Given
        userRepository.deleteAll();

        userService.create(new User("fred", "auge"));
        userService.create(new User("fred", "foo"));
        // when
        List<User> users = userService.list("foo", null);
        assertNotNull(users);
        //Then
        assertEquals(1, users.size());
        assertEquals("foo", users.get(0).getLastName());
    }

    @Test
    void findUsersByNameNoResultTest() {
        // Given
        userRepository.deleteAll();

        userService.create(new User("fred", "auge"));
        userService.create(new User("fred", "foo"));
        // when
        List<User> users = userService.list("bar", "");
        assertNotNull(users);
        //Then
        assertEquals(0, users.size());
    }

    @Test
    void findUsersByLastNameAndFirstNameTest() {
        // Given
        userRepository.deleteAll();

        userService.create(new User("fred", "auge"));
        userService.create(new User("fred", "foo"));
        // when
        List<User> users = userService.list("foo", "fred");
        assertNotNull(users);
        //Then
        assertEquals(1, users.size());
        assertEquals("foo", users.get(0).getLastName());
        assertEquals("fred", users.get(0).getFirstName());
    }
}