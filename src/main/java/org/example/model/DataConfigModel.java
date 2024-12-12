package org.example.model;

import java.io.Serial;
import java.io.Serializable;

public class DataConfigModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
    private int remainsToBeReleasedVendor;

    public DataConfigModel(int id, int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.id = id;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
        this.remainsToBeReleasedVendor = totalTickets;
    }

    public DataConfigModel(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
        this.remainsToBeReleasedVendor = totalTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getRemainingTickets() {
        return maxTicketCapacity - totalTickets;
    }

    public int getRemainsToBeReleasedVendor() {
        return remainsToBeReleasedVendor;
    }

    public void setRemainsToBeReleasedVendor(int remainsToBeReleasedVendor) {
        this.remainsToBeReleasedVendor = remainsToBeReleasedVendor;
    }

    @Override
    public String toString() {
        return "DataConfigModel{" +
                "id=" + id +
                ", totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }
}
