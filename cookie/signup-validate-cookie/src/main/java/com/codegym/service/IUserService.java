package com.codegym.service;

import com.codegym.model.User;

import java.util.HashMap;
import java.util.List;

public interface IUserService {
    List<User> getAllUser();
    void addUser(User user);
    void updateUser(User user);
    boolean isUserExist(User user);
    boolean checkSignin(User user);

    HashMap<String, String> getUserMap();
}
