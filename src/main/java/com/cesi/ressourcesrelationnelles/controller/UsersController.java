package com.cesi.ressourcesrelationnelles.controller;

import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.infrastructure.UserDto;
import com.cesi.ressourcesrelationnelles.infrastructure.UserMapper;
import com.cesi.ressourcesrelationnelles.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UsersController {
    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UsersController.class);

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam(required = false) String lastName, @RequestParam(required = false) String firstName) {
        if (lastName != null || firstName != null) {
            return userService.list(lastName, firstName);
        }
        return userService.list();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id) {
        try {
            return userService.findById(id);
        } catch (NotFoundException e) {
            logger.warn("user {} not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody User user) {
        UserMapper userMapper = new UserMapper();

        return userMapper.toDto(userService.create(user));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.delete(id);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUserById(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        UserMapper userMapper = new UserMapper();
        return userMapper.toDto(userService.update(user));
    }
}