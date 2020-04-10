package com.codegym.service.Impl;

import com.codegym.model.UserModel.User;
import com.codegym.repositories.User.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public boolean isUserExist(User user) {
        HashMap<String, String> userMap = getUserMap();
        if (!userMap.isEmpty()) {
            if (userMap.containsKey(user.getName())) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    @Override
    public boolean checkSignin(User user) {
        HashMap<String, String> userMap = getUserMap();
        if (userMap.containsKey(user.getName())
                && userMap.get(user.getName()).equals(user.getPassword())) {
            return true;
        } else
            return false;
    }


    @Override
    public HashMap<String, String> getUserMap() {
        HashMap<String, String> userMap = new HashMap<>();
        List<User> userList = getAllUser();
        if (userList != null) {
            for (User u : userList) {
                userMap.put(u.getName(), u.getPassword());
            }
        }

        return userMap;
    }
}
