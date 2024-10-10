package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> findAll();

    User getByID(Long id);

    void update(Long id, User user);

    void delete(User user);
}