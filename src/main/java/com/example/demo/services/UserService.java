package com.example.demo.services;

import com.example.demo.Domain.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jesse on 2017/2/12.
 */

public interface UserService {
    User login(String userName,String password);
    User register(String userName,String password);
}
