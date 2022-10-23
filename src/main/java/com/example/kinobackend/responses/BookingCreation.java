package com.example.kinobackend.responses;

public class BookingCreation {
    private String email;
    private int[] ticketIds;

    public BookingCreation(String email, int[] ticketIds) {
        this.email = email;
        this.ticketIds = ticketIds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int[] getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(int[] ticketIds) {
        this.ticketIds = ticketIds;
    }
}
