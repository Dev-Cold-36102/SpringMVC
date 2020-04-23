package com.codegym.service.User.Impl;

import com.codegym.model.UserModel.User;
import com.codegym.repositories.User.IUserRepo;
import com.codegym.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepo userRepo;


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


    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepo.save(user);
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
}
