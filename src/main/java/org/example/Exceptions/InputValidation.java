package org.example.Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidation {

    public int Validate(Scanner scanner) {
        while (true) {
            System.out.println("( CONFIG ) Enter the Max Capacity of Retrieve: ");
            try {
                int validateValue = scanner.nextInt();
                if (validateValue > 0) {
                    return validateValue;
                } else {
                    System.out.println("( ERROR - INPUT VALIDATION ) - Invalid Value, Please Enter a Positive Number: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("( ERROR - INPUT VALIDATION ) - Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    public int Validate(Scanner scanner, int maxCapacity) {
        System.out.println("( CONFIG ) Enter the Max Tickets Released: ");
        while (true) {
            try {
                int validateValue = scanner.nextInt();
                if (validateValue > 0 && validateValue <= maxCapacity) {
                    return validateValue;
                } else {
                    System.out.println("( ERROR - INPUT VALIDATION ) - Invalid Value. Please enter a positive number and less than Max Capacity.");
                }
            } catch (InputMismatchException e) {
                System.out.println("( ERROR - INPUT VALIDATION ) - Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }


    public int Validate(Scanner scanner, String RateName) {
        System.out.println("( ? ) Enter the " + RateName + ": ");
        while (true) {
            try {
                int validateValue = scanner.nextInt();
                if (validateValue > 0) {
                    return validateValue;
                } else {
                    System.out.println("( ERROR - INPUT VALIDATION ) - Invalid Value. Please enter a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("( ERROR - INPUT VALIDATION ) - Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }


    public int InputValidation(Scanner scanner) {
        while (true) {
            System.out.println("Please enter a positive number: ");
            try {
                int validateValue = scanner.nextInt();
                if (validateValue > 0) {
                    return validateValue;
                } else {
                    System.out.println("( ERROR - INPUT VALIDATION ) - Invalid Value. Please enter a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("( ERROR - INPUT VALIDATION ) - Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

}
