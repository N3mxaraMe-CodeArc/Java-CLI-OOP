package org.example.model;

public class VendorProducerModel {
    private final TicketPoolModel ticketPoolModel;
    private final int totalTickets;
    private final int ticketReleaseRate;

    public VendorProducerModel(TicketPoolModel ticketPoolModel, int totalTickets, int ticketReleaseRate) {
        this.ticketPoolModel = ticketPoolModel;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public TicketPoolModel getTicketPoolModel() {
        return ticketPoolModel;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }




}
