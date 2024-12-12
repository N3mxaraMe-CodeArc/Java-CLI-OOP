package org.example.model;

public class CustomerConsumerModel {
    private final TicketPoolModel ticketPoolModel;
    private final int retrievalRate;

    public CustomerConsumerModel(TicketPoolModel ticketPoolModel, int retrievalRate) {
        this.ticketPoolModel = ticketPoolModel;
        this.retrievalRate = retrievalRate;
    }

    public TicketPoolModel getTicketPoolModel() {
        return ticketPoolModel;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }
}
