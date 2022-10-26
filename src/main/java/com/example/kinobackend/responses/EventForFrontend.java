package com.example.kinobackend.responses;

import java.sql.Time;
import java.util.Date;

public class EventForFrontend {
    private Event event;
    public EventForFrontend(long id, Date date, String time, long movieId, long roomId) {
        event = new Event(id,date,Time.valueOf(time),movieId,roomId);
    }
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
