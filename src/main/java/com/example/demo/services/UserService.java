package com.example.demo.services;

import com.example.demo.domain.User;

/**
 * Created by jesse on 2017/2/12.
 */

public interface UserService {
    User login(String userName,String password);
    User register(String userName,String password);
    User findByUserName(String userName);
    User findByEmail(String email);
}
