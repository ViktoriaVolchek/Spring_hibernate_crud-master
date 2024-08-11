package ru.forITMSpace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.forITMSpace.dao.UserDao;
import ru.forITMSpace.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        if (user == null) {
            throw new RuntimeException("there is not provided user to save in database! ");
        }
        userDao.addUser(user);
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        Optional<List<User>> users = userDao.getAll();
        if (users.isEmpty()) {
            throw new RuntimeException("empty user list! ");
        }
        return users;
    }

    @Override
    public Optional<User> getUserById(long id) {
        if (id <= 0) {
            throw new RuntimeException("Invalid id! ");
        }
        Optional<User> user = userDao.getById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("Invalid user! ");
        }
        return user;
    }

    @Override
    public void editUser(User user) {
        if (user == null) {
            throw new RuntimeException("Invalid user! ");
        }
        userDao.editUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        if (id <= 0) {
            throw new RuntimeException("Invalid id! ");
        }
        userDao.removeById(id);
    }
}
