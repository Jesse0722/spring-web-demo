package com.example.demo.repositories;

import com.example.demo.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;




/**
 * Created by jesse on 2017/2/12.
 */
public interface UserRepository extends MongoRepository<User,String>{
    User findByUserName(String userName);

    User insert(User user);
}
