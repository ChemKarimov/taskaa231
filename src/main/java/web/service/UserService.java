package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void update(User user);
    void delete(User user);
    User getUserById(int id);

}