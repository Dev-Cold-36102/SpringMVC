package com.codegym.service.Imp;

import com.codegym.model.User;
import com.codegym.repositories.IUserRepository;
import com.codegym.repositories.Impl.UserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public HashMap<String, String> getUserMap() {
        HashMap<String, String> userMap = new HashMap<>();
        List<User> userList = getAllUser();
        for (User u : userList) {
            userMap.put(u.getName(), u.getPassword());
        }
        return userMap;
    }

    public HashMap<String, String> userMap = getUserMap();




    public UserService() {
    }

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
        if (userMap.containsKey(user.getName())
                && userMap.get(user.getName()).equals(user.getPassword())) {
            return true;
        } else
            return false;
    }
}
