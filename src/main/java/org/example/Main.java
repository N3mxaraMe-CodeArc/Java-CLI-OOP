package org.example;

import org.example.Authentication.AdminAuth;
import org.example.Scenario.VendorScenario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.MainMenu();
    }

    public void MainMenu() {

        AdminAuth adminAuth = new AdminAuth();
        VendorScenario vendorScenario = new VendorScenario();

        System.out.print("""
                
                
                Welcome to Ticket Ministry Event Booking System
                
                Please Select your Role
                1. Admin
                2. Vendor
                
                Enter the Role Number :
                """);

        Scanner scanner = new Scanner(System.in);
        int role = scanner.nextInt();

        switch (role) {
            case 1:
                adminAuth.AdminAuthorization();
                break;
            case 2:
                vendorScenario.VendorSession();
                break;
            default:
                System.out.println("(ERROR-404) Invalid Role");
                MainMenu();
        }
    }
}