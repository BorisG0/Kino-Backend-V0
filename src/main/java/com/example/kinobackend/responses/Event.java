package com.example.kinobackend.responses;
import java.sql.Time;
import java.util.Date;

public class Event {
     private long EventId;
     private Date date;
     private Time time;
     private long MovieId;
     private long RoomId;

     public Event(long eventId, Date date, Time time, long movieId, long roomId) {
          EventId = eventId;
          this.date = date;
          this.time = time;
          MovieId = movieId;
          RoomId = roomId;
     }

     public long getEventId() {
          return EventId;
     }

     public void setEventId(long eventId) {
          EventId = eventId;
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
          return MovieId;
     }

     public void setMovieId(long movieId) {
          MovieId = movieId;
     }

     public long getRoomId() {
          return RoomId;
     }

     public void setRoomId(long roomId) {
          RoomId = roomId;
     }
}
