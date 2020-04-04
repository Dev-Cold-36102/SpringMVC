package com.codegym.repositories;

import com.codegym.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRepository {
    List<User> getAllUser();
    void addUser(User user);
    void updateUser(User user);
    boolean isUserExist(User user);
}
