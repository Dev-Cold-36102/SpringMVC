package com.codegym.repositories.User;

import com.codegym.model.UserModel.User;

import java.util.List;

public interface IUserRepository {

    List<User> getAllUser();
    void addUser(User user);
    void updateUser(User user);
}
