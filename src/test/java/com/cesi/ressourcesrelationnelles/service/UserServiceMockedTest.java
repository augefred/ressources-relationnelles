package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceMockedTest {

    @InjectMocks
    public UserService userService;

    @Mock
    public UserRepository userRepository;

    @BeforeTestClass
    public void initMock() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findUsersByNameTest() {
        // Given
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User("fred", "auge"));
        mockUsers.add(new User("fred", "foo"));

        Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

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
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User("fred", "auge"));
        mockUsers.add(new User("fred", "foo"));

        Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

        // when
        List<User> users = userService.list("bar", "");
        assertNotNull(users);
        //Then
        assertEquals(0, users.size());
    }

    @Test
    void findUsersByLastNameAndFirstNameTest() {
        // Given

        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User("fred", "auge"));
        mockUsers.add(new User("fred", "foo"));

        Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

        // when
        List<User> users = userService.list("foo", "fred");
        assertNotNull(users);
        //Then
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
        assertEquals(1, users.size());
        assertEquals("foo", users.get(0).getLastName());
        assertEquals("fred", users.get(0).getFirstName());
    }
}