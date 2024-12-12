package org.example.service;

import org.example.model.VendorProducerModel;

import java.util.logging.Logger;

public class VendorProducer implements Runnable {

    private final VendorProducerModel vendorProducerModel;
    private final int vendorId;

    public VendorProducer(VendorProducerModel vendorProducerModel, int vendorId) {
        this.vendorProducerModel = vendorProducerModel;
        this.vendorId = vendorId;
    }

    Logger logger = Logger.getLogger(VendorProducer.class.getName());

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (vendorProducerModel.getTicketPoolModel()) {
                try {

                    if (vendorProducerModel.getTicketPoolModel().getTicketCount() >= vendorProducerModel.getTicketPoolModel().getTotalTickets()) {
                        vendorProducerModel.getTicketPoolModel().notifyAll();
                        break;
                    }

                    vendorProducerModel.getTicketPoolModel().addTicket(vendorId, vendorProducerModel.getTicketReleaseRate());
                    vendorProducerModel.getTicketPoolModel().notifyAll();

                } catch (Exception e) {
                    logger.warning("Vendor " + vendorId + ": ERROR 500- Internal Server Error. Exiting.");
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.warning("( VENDOR ERROR : )Vendor " + vendorId + ": Interrupted during sleep in Implementing Runnable. Exiting.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
