package org.example.Scenario;

import org.example.Exceptions.InputValidation;
import org.example.controller.DataConfigController;
import org.example.model.*;
import org.example.service.CustomerConsumer;
import org.example.service.VendorProducer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class VendorScenario {

    DataConfigModel createdDataConfig;

    public void VendorSession() {

        Logger logger = Logger.getLogger(VendorScenario.class.getName());

        DataConfigController dataConfigController = new DataConfigController();

        System.out.println("==============================");
        System.out.println("Welcome to Vendor Dashboard");
        System.out.println("===============================");

        System.out.println("""
                1) Start a Event
                2) Stop the Event
                """);

        Scanner scanner = new Scanner(System.in);
        int vendorOption = scanner.nextInt();

        switch (vendorOption) {
            case 1:
                try {
                    createdDataConfig = dataConfigController.LoadDataConfig();
                    TicketPoolModel ticketPoolModel = new TicketPoolModel(createdDataConfig.getTotalTickets());

                    ArrayList<Thread> vendorProducerThreads = new ArrayList<>();
                    ArrayList<Thread> customerConsumerThreads = new ArrayList<>();


                    int numOfVendors = 8;
                    int numOfCustomers = 6;

                    System.out.println("Event Started with " + numOfVendors + " Vendors and " + numOfCustomers + " Customers");

                    for (int i = 0; i < numOfVendors; i++) {
                        VendorProducerModel vendorProducerModel = new VendorProducerModel(ticketPoolModel, createdDataConfig.getTotalTickets(), createdDataConfig.getTicketReleaseRate());
                        VendorProducer vendorProducer = new VendorProducer(vendorProducerModel, i + 1);
                        Thread vendorProducerThread = new Thread(vendorProducer);
                        vendorProducerThread.setName("Vendor-" + (i + 1));
                        vendorProducerThreads.add(vendorProducerThread);
                        vendorProducerThread.start();
                    }

                    for (int i = 0; i < numOfCustomers; i++) {
                        CustomerConsumerModel customerConsumerModel = new CustomerConsumerModel(ticketPoolModel, createdDataConfig.getCustomerRetrievalRate());
                        CustomerConsumer customerConsumer = new CustomerConsumer(customerConsumerModel, i + 1);
                        Thread customerConsumerThread = new Thread(customerConsumer);
                        customerConsumerThread.setName("Customer-" + (i + 1));
                        customerConsumerThread.start();
                        customerConsumerThreads.add(customerConsumerThread);
                    }

                    System.out.println("Event Started Successfully");

                    while (true) {
                        try {
                            System.out.println("Do you want to stop the event ? PRESS 2 to stop");
                            int input = scanner.nextInt();


                            if (input == 2) {
                                for (Thread vendorProducerThread : vendorProducerThreads) {
                                    vendorProducerThread.interrupt();
                                }
                                for (Thread customerConsumerThread : customerConsumerThreads) {
                                    customerConsumerThread.interrupt();
                                }

                                logger.info("Event stopped successfully");

                                break;
                            } else {
                                System.out.println("Invalid Input");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }


                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                break;

            case 2:
                logger.info("Event stopped successfully");
                break;

            default:
                System.out.println("Invalid Input");
                VendorSession();
        }
    }
}
