package org.example.service;

import org.example.model.CustomerConsumerModel;

import java.util.logging.Logger;

public class CustomerConsumer implements Runnable{

    private final CustomerConsumerModel customerConsumerModel;
    int CustomerId;

    public CustomerConsumer(CustomerConsumerModel customerConsumerModel,int customerId) {
        this.customerConsumerModel = customerConsumerModel;
        this.CustomerId = customerId;
    }

    Logger logger = Logger.getLogger(CustomerConsumer.class.getName());

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try{
                if (customerConsumerModel.getTicketPoolModel().getTicketCount() > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        logger.warning("Customer " + CustomerId + ": ERROR 500- Internal Server Error. Exiting.");
                        Thread.currentThread().interrupt();
                        break;
                    }
                    customerConsumerModel.getTicketPoolModel().retrieveTicket(CustomerId,customerConsumerModel.getRetrievalRate());

                } else {
                    synchronized (customerConsumerModel.getTicketPoolModel()) {
                        customerConsumerModel.getTicketPoolModel().wait();
                    }
                }
            } catch (InterruptedException e) {
                logger.warning("Customer " + CustomerId + ": ERROR 500- Internal Server Error. Exiting.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
