package com.codegym.repositories;

import com.codegym.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepo  {
    User getUserByUsername(String username);
}
