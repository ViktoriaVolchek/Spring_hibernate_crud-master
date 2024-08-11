package ru.forITMSpace.service;

import ru.forITMSpace.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    Optional<List<User>> getAllUsers();
    Optional<User> getUserById(long id);
    void editUser(User user);
    void deleteUserById(long id);
}
