package com.example.demo.repositories.customRepository;

import java.util.List;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by jesse on 2017/2/17.
 */
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @Autowired
    private MongoTemplate template;

    @Override
    public User findByEmail(String email) {
        Criteria criteria = Criteria.where("email").is(email);
        List<User> users = template.find(Query.query(criteria),User.class);

        return users==null?null:users.get(0);
    }
}
