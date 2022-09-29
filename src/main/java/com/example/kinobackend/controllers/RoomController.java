package com.example.kinobackend.controllers;

import com.example.kinobackend.db_access.RoomSQL;
import com.example.kinobackend.responses.Room;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @GetMapping("/api/rooms")
    public Room[] getRooms(){
        System.out.println("getting rooms");
        RoomSQL connector = new RoomSQL();
        Room[] rooms = connector.getRoomData();
        return rooms;
    }

}
