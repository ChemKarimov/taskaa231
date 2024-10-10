package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User getByID(Long id);

    List<User> findAll();

    void update(Long id, User user);

    void delete(User user);
}