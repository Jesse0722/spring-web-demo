package com.example.demo.repositories.customRepository;

import com.example.demo.domain.User;
/**
 * Created by jesse on 2017/2/17.
 */
public interface UserCustomRepository {

    User findByEmail(String email);
}
