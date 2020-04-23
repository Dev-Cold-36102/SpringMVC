package com.codegym.service.User.Impl;

import com.codegym.model.User.User;
import com.codegym.repositories.User.IUserRepository;
import com.codegym.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public HashMap<String, String> getUserMap() {
        HashMap<String, String> userMap = new HashMap<>();
        List<User> userList = getAllUser();
        if (userList != null) {
            for (User u : userList) {
                userMap.put(u.getUsername(), u.getPassword());
            }
        }

        return userMap;
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
        HashMap<String, String> userMap = getUserMap();
        if (!userMap.isEmpty()) {
            if (userMap.containsKey(user.getUsername())) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    @Override
    public boolean checkSignin(User user) {
        HashMap<String, String> userMap = getUserMap();
        if (userMap.containsKey(user.getUsername())
                && userMap.get(user.getUsername()).equals(user.getPassword())) {
            return true;
        } else
            return false;
    }
}

