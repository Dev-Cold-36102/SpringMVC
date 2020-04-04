package com.codegym.repositories;

import com.codegym.model.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUser();
    void addUser(User user);
    void updateUser(User user);
    boolean isUserExist(User user);
}
