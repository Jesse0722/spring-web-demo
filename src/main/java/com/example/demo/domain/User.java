package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jesse on 2017/2/12.
 */
@Document(collection = "user")
public class User {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;

    private String userName;

    private String password;

    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Username:"+userName+"\n"+"Password:"+password+"\n"+"Email:"+email;
    }


}
