package com.example.demo.repositories;

import com.example.demo.domain.User;
import com.example.demo.repositories.customRepository.UserCustomRepository;
import org.springframework.data.mongodb.repository.MongoRepository;




/**
 * Created by jesse on 2017/2/12.
 */
public interface UserRepository extends MongoRepository<User,String>,UserCustomRepository{//组合自定的方法
    User findByUserName(String userName);

    User insert(User user);
}
