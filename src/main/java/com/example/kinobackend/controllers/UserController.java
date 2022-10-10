package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.UserSQL;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/user")
    public String getUserFromLoginData(@RequestBody String mailAdress, String password){
    //public String getUserFromLoginData(){
        System.out.println("getting user");
        UserSQL connector = new UserSQL();
        String returnString = connector.getUserFromLoginData(mailAdress, password);
        //String returnString = connector.getUserFromLoginData("aberger3@posterous.com","MiBtueRSa");
        return returnString;
    }

}
