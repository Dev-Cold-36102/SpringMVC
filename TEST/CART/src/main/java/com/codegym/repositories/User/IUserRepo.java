package com.codegym.repositories.User;

import com.codegym.model.UserModel.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepo extends PagingAndSortingRepository<User,Long> {
    Iterable<User> findAllByNameStartsWith(String name);
}
