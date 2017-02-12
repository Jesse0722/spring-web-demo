package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jesse on 2016/10/28.
 */
    @RestController
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
