package org.bootcamp.dao;

import org.bootcamp.models.User;

import java.util.List;

public interface UserDAO {

    void createUser(User user);
    void updateUser(int id);
    void deleteUser(int id);
    User getUser(int id);
    List<User> getUsers();
}
