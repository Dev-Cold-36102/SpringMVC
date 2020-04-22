package com.codegym.service;


import com.codegym.repositories.IUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
    private IUserRepo userRepo;
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


}
