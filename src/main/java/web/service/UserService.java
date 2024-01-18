package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User updatedUser);

    User getUserById(int id);

    void deleteUser(int id);
}