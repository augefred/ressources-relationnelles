package com.cesi.ressourcesrelationnelles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cesi.ressourcesrelationnelles.domain.User;

import java.util.Collections;
import java.util.List;

@RestController
public class UsersController {

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return Collections.singletonList(new User());
    }

}