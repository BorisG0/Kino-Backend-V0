package com.example.kinobackend.responses;
import com.example.kinobackend.db_access.EventSQL;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Event {
     private long id;
     private Date date;
     private Time time;
     private long movieId;
     private long roomId;
     private int freeSeats;

     public String toString(){
          return "Event(id: " + id + " date: " + date + " time: " + time + " MovieId: " + movieId + " RoomId: " + roomId + ")";
     }

     public Event(){}
     public Event(long id, Date date, Time time, long movieId, long roomId) {
          this.id = id;
          this.date = date;
          this.time = time;
          this.movieId = movieId;
          this.roomId = roomId;
          EventSQL eventSQL = new EventSQL();
          this.freeSeats = eventSQL.getFreeSeatsForEvent(id);
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public Date getDate() {
          return date;
     }

     public void setDate(Date date) {
          this.date = date;
     }

     public Time getTime() {
          return time;
     }

     public void setTime(Time time) {
          this.time = time;
     }

     public long getMovieId() {
          return movieId;
     }

     public void setMovieId(long movieId) {
          this.movieId = movieId;
     }

     public long getRoomId() {
          return roomId;
     }

     public void setRoomId(long roomId) {
          this.roomId = roomId;
     }

     public int getFreeSeats() {
          return freeSeats;
     }
}
