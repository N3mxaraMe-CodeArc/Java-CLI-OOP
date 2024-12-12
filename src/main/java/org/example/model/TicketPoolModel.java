package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.Logger;

public class TicketPoolModel {
    private final int totalTickets;
    private int currentCapacity = 0;
    private int PoolUpdateTickets;
    private final Queue<Integer> tickets = new SynchronousQueue<>();

    public TicketPoolModel(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    Logger logger = Logger.getLogger(TicketPoolModel.class.getName());

    public void addTicket(int VendorId, int ticketReleaseRate) {
        synchronized (this) {
            if (PoolUpdateTickets <= this.totalTickets){
                try{
                    Thread.sleep(ticketReleaseRate);
                }catch (InterruptedException e){
                    logger.warning("ERROR : Vendor Thread Interrupted during the ticket Retrieval Rate Waiting");
                    Thread.currentThread().interrupt();
                    return;
                }

                try {
                    while (currentCapacity >= this.totalTickets) {
                        System.out.println("WARNING : Ticket pool is full, waiting to add...");
                        wait();
                    }
                    tickets.offer(1);
                    currentCapacity++;
                    PoolUpdateTickets++;

                    LocalDateTime retrievalTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                    System.out.println("VENDOR INFO : { " + VendorId + " Vendor } Release 1 Ticket to the pool," + " Current capacity: " + currentCapacity + ", Release At : " + retrievalTime.format(formatter));
                    notifyAll();

                    System.out.println("TICKET POOL : Total Tickets in the pool "+ PoolUpdateTickets +" , Current capacity: " + currentCapacity);

                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                    logger.warning("ERROR : Thread interrupted during ticket addition");
                    throw new RuntimeException(e);
                }
            }else {
                System.out.println("TICKET POOL : Ticket pool is full, no more tickets can be added");
            }

        }
    }

    public void retrieveTicket(int CustomerId, int retrievalRate) {
        synchronized (this){

            try{
                Thread.sleep(retrievalRate);
            }catch (InterruptedException e){
                System.out.println("ERROR : Customer Sleep Interrupted");
                Thread.currentThread().interrupt();
                return;
            }

            try {
                while (currentCapacity <= 0) {
                    System.out.println("TICKET POOL : No tickets available, waiting to retrieve...");
                    wait();
                }

                tickets.poll();
                currentCapacity--;

                LocalDateTime retrievalTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


                System.out.println("CUSTOMER INFO : { "+ CustomerId + " Customer } Ticket bought by Customer , Ticket Remains : " + currentCapacity + ", Retrieval At : " + retrievalTime.format(formatter));
                notifyAll();

            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("ERROR : Thread interrupted during ticket retrieval");
            }
        }
    }

    public int getTicketCount() {
        return PoolUpdateTickets;
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}
