package com.cesi.ressourcesrelationnelles.service;

import com.cesi.ressourcesrelationnelles.domain.User;
import com.cesi.ressourcesrelationnelles.exception.NotFoundException;
import com.cesi.ressourcesrelationnelles.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public List<User> list(String lastName, String firstName) {
        List<User> userList = userRepository.findAll();
        if (lastName != null) {
            userList = userList.stream().filter(user ->
                    user.getLastName().equals(lastName)).collect(Collectors.toList());
        }
        if (firstName != null) {
            userList = userList.stream().filter(user ->
                    user.getFirstName().equals(firstName)).collect(Collectors.toList());
        }

        return userList;
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
}
