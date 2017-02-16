package com.example.demo.services;

import com.example.demo.batch.CompanyItemProcessor;
import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by jesse on 2017/2/12.
 */
@Service
public class UserServiceImpl implements UserService {

    public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
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

    /***
     * Cacheable
     * 这个注释的意思是，当调用这个方法的时候，会从一个名叫 usercache 的缓存中查询，
     * 如果没有，则执行实际的方法（即查询数据库），并将执行的结果存入缓存中，否则返回缓存中的对象。
     * 这里的缓存中的 key 就是参数 userName，value 就是 User 对象。
     * @param userName
     * @return
     */
    @Override
    @Cacheable(value = "usercache",keyGenerator = "keyGenerator")  //传入在配置文件中的参数
    public User findByUserName(String userName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        log.info("查询MongoDB----username:"+userName );
        return userRepository.findByUserName(userName);
    }

    @Override
    @Cacheable(value = "usercache",keyGenerator = "keyGenerator")
    public User findByEmail(String email) {
        log.info("查询MongoDB----email:"+email );
        return userRepository.findByEmail(email);
    }
}
