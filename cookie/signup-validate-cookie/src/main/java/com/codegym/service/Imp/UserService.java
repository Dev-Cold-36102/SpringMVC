package com.codegym.service.Imp;

import com.codegym.model.User;
import com.codegym.repositories.Impl.UserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class UserService implements IUserService {
    private HashMap<String, String> userMap = new HashMap<>();
    public UserService() {
        this.userMap = getUserMap();
    }

    public HashMap<String, String> getUserMap() {
        HashMap<String, String> userHashMap = new HashMap<>();
        List<User> userList = getAllUser();
        for (User u : userList) {
            userHashMap.put(u.getName(), u.getPassword());
        }
        return userHashMap;
    }


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return this.userRepository.getAllUser();
    }

    @Override
    public void addUser(User user) {
        this.userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        this.userRepository.updateUser(user);
    }

    @Override
    public boolean isUserExist(User user) {
        return this.userRepository.isUserExist(user);
    }

    @Override
    public boolean checkSignin(User user) {
        if (this.userMap.containsKey(user.getName())
                && this.userMap.get(user.getName()).equals(user.getPassword())) {
            return true;
        } else
            return false;
    }
}
