package org.example.Scenario;

import org.example.Exceptions.InputValidation;
import org.example.Main;
import org.example.controller.DataConfigController;
import org.example.model.DataConfigModel;

import java.util.Scanner;

public class AdminScenario {
    public void AdminSession() {

        Scanner scanner = new Scanner(System.in);
        InputValidation Validations = new InputValidation();
        DataConfigController dataConfigController = new DataConfigController();

        System.out.println("""
                1) Do you want to Start new Event .?
                2) Do you want to add ticket to the existing Event .?
                
                (?) Enter the Option Number :
                """);

        int adminOption = scanner.nextInt();

        switch (adminOption) {
            case 1:
                System.out.println("""
                        ===============================================================
                        ==================== Event Configuration ======================
                        ===============================================================
                        
                        """);


//                Get Data Configuration from Admin

                int maxCapacity = Validations.Validate(scanner);
                int maxTickets = Validations.Validate(scanner, maxCapacity);
                int ticketReleaseRate = Validations.Validate(scanner, "Ticket Release Rate");
                int retrievalRate = Validations.Validate(scanner, "retrieval Rate");

//                set to the data model
                DataConfigModel createdDataConfig = new DataConfigModel(maxTickets, ticketReleaseRate, retrievalRate, maxCapacity);

                createdDataConfig.setTotalTickets(maxTickets);
                createdDataConfig.setTicketReleaseRate(ticketReleaseRate);
                createdDataConfig.setCustomerRetrievalRate(retrievalRate);
                createdDataConfig.setMaxTicketCapacity(maxCapacity);

                try {
                    if (dataConfigController.saveToTheFile(createdDataConfig)) {
                        System.out.println("============================================================");
                        BackMainMenu();


                    } else {
                        System.out.println("( TEXT FILE - 500 INTERNAL SERVER ERROR ) : Data Configuration Failed");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try {
                    createdDataConfig = dataConfigController.LoadDataConfig();
                    System.out.println("(ADMIN : ADD TICKET ) : You can add upto " + createdDataConfig.getRemainingTickets() + ", Enter the Number of Tickets to Add : ");
                    int tickets = Validations.InputValidation(scanner);

                    if (tickets <= createdDataConfig.getRemainingTickets()) {
                        createdDataConfig.setTotalTickets(createdDataConfig.getTotalTickets() + tickets);
                        if (dataConfigController.saveToTheFile(createdDataConfig)) {
                            System.out.println("(ADMIN : ADD TICKET ) : Tickets Added Successfully");
                            System.out.println("( TEXT FILE - 201 CREATED ) : Data Configuration Updated");
                        } else {
                            System.out.println("(TEXT FILE - 500 INTERNAL SERVER ERROR ) : Tickets Adding Failed");
                        }
                    }

                    System.out.println("============================================================");
                    BackMainMenu();


                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public void BackMainMenu() {

        System.out.println("============================================================");
        System.out.println("Do you want to back to main menu .? (Y/N)");

        Scanner scanner = new Scanner(System.in);
        String startEvent = scanner.next();

        if (startEvent.equalsIgnoreCase("Y")) {
            Main main = new Main();
            main.MainMenu();
        } else if (startEvent.equalsIgnoreCase("N")) {
            System.out.println("============================================================");
            System.out.println("( ❤ ) Thank you for using Ticket Ministry Event Booking System ( ❤ )");
            System.out.println("============================================================");
            AdminSession();
        } else {
            System.out.println("( ERROR ): Invalid Option");
            AdminSession();
        }
    }
}
