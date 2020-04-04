package com.codegym.service.Imp;

import com.codegym.model.User;
import com.codegym.repositories.IUserRepository;
import com.codegym.repositories.Impl.UserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

public class UserService implements IUserService {
    public UserService() {
    }

    public HashMap<String, String> getUserMap() {
        HashMap<String, String> userMap = new HashMap<>();
        List<User> userList = getAllUser();
        for (User u : userList) {
            userMap.put(u.getName(), u.getPassword());
        }
        return userMap;
    }

    public HashMap<String, String> userMap = getUserMap();

    @Autowired
    UserRepository userRepository;

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
        return userRepository.isUserExist(user);
    }

    @Override
    public boolean checkSignin(User user) {
        if (userMap.containsKey(user.getName())
                && userMap.get(user.getName()).equals(user.getPassword())) {
            return true;
        } else
            return false;
    }
}
