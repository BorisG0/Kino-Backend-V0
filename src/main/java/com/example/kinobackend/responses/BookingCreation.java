package com.example.kinobackend.responses;

public class BookingCreation {
    private int customerId;
    private int[] ticketIds;

    public BookingCreation(int customerId, int[] ticketIds) {
        this.customerId = customerId;
        this.ticketIds = ticketIds;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int[] getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(int[] ticketIds) {
        this.ticketIds = ticketIds;
    }
}
