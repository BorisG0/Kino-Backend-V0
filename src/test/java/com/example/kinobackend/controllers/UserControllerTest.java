package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.UserSQL;
import com.example.kinobackend.responses.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    UserController testUserController;
    UserSQL testUserSQL;

    @BeforeEach
    void setUp() {
        testUserController = new UserController();
        testUserSQL = new UserSQL();
    }

    @AfterEach
    void tearDown() {
        testUserController = null;
        testUserSQL = null;
    }

    @Test
    void getUserFromLoginData() {
        User testUser = new User("agrealeya@who.int", "LeYfgdoAfznW");
        User actualUser = testUserController.getUserFromLoginData(testUser);
        User expectedUser = testUserSQL.getUserFromLoginData(testUser.getMailAdress(), testUser.getPassword());
        assertThat(expectedUser).usingRecursiveComparison().isEqualTo(actualUser);
    }
}