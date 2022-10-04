package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.UserSQL;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/user")
    public Object getUserFromLoginData(@RequestBody String mailAdress, String password){
        System.out.println("getting user");
        UserSQL connector = new UserSQL();
        Object user = connector.getUserFromLoginData(mailAdress, password);
        return user;
    }

}
