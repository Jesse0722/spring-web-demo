package com.example.demo.services;

import com.example.demo.Domain.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

/**
 * Created by jesse on 2017/2/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String userName, String password) {
        User user =  userRepository.findByUserName(userName);
        if(user !=null){
            //这里需要进行auth验证
            if(user.getPassword()== password){
                return user;
            }
         }
        return null;
    }

    @Override
    public User register(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        if(user!=null){
            user.setPassword(password);
            userRepository.insert(user);
            return user;
        }

        return null;
    }
}
