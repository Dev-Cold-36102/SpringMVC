package com.codegym.service.Imp;

import com.codegym.model.User;
import com.codegym.repositories.IUserRepository;
import com.codegym.repositories.Imp.UserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class UserServiceImp implements IUserService {
    @Autowired
    UserRepository userRepository;

    public List<User> userList = getAllUser();

    public HashMap<String, String> getUserName() {
        HashMap<String, String> userName = new HashMap<>();
        for (User user : userList) {
            userName.put(user.getFirstName(), user.getLastName());
        }
        return userName;
    }

    public HashMap<String, String> userNameMap = getUserName();

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
        userNameMap.put(user.getFirstName(), user.getLastName());
    }

    @Override
    public boolean checkUserExist(User user) {
        if (userNameMap.containsKey(user.getFirstName())
                && userNameMap.get(user.getFirstName()).equals(user.getLastName())) {
            return false;
        } else
            return true;
    }
}
