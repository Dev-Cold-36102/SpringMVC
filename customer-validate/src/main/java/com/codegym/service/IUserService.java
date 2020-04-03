package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    void  addUser(User user);
    boolean checkUserExist(User user);
}
