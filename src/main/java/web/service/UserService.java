package web.service;

import web.model.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(@Valid User updatedUser);

    User getUserById(int id);

    void deleteUser(int id);
}