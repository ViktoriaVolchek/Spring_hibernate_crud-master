package ru.forITMSpace.dao;

import ru.forITMSpace.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);
    Optional<List<User>> getAll();
    Optional<User> getById(long id);
    void editUser(User user);
    void removeById(long id);
}
