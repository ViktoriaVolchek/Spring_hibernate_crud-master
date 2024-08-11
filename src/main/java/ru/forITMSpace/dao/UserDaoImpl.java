package ru.forITMSpace.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.forITMSpace.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager manager;
    @Override
    public void addUser(User user) {
        manager.persist(user);
    }

    @Override
    public Optional<List<User>> getAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = manager.createQuery(jpql, User.class);
        List<User> users = query.getResultList();
        return Optional.ofNullable(users);
    }

    @Override
    public Optional<User> getById(long id) {
        return Optional.ofNullable(manager.find(User.class, id));
    }

    @Override
    public void editUser(User user) {
        manager.merge(user);
    }

    @Override
    public void removeById(long id) {
        User user = this.getById(id).get();
        manager.remove(user);
    }
}
