package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.UserSQL;
import com.example.kinobackend.responses.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/user")
    public User getUserFromLoginData(@RequestBody String mailAdress, String password){
    //public User getUserFromLoginData(){
        System.out.println("getting user");
        UserSQL connector = new UserSQL();
        User user = connector.getUserFromLoginData(mailAdress, password);
        //User user = connector.getUserFromLoginData("aberger3@posterous.com","MiBtueRSa");
        return user;
    }

}
