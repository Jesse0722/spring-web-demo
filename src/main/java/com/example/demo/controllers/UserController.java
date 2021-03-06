package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jesse on 2017/2/12.
 */

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(String userName, String password){
        return userService.login(userName,password);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public User register(String userName, String password){
        return userService.register(userName,password);
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User findByUserName(String userName){
        return userService.findByUserName(userName);
    }

    @RequestMapping(value = "/user/email",method = RequestMethod.GET)
    public User findByEmail(String email){
        return userService.findByEmail(email);
    }
}
