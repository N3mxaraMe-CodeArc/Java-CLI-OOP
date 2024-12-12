package org.example.Authentication;

import org.example.Main;
import org.example.Scenario.AdminScenario;
import java.util.Objects;
import java.util.Scanner;

public class AdminAuth {

    Main main = new Main();
    AdminScenario adminScenario = new AdminScenario();

    public void AdminAuthorization() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("( ? ) Enter your Admin Username");
        String username = scanner.nextLine();

        System.out.println("( ? ) Enter your Admin Password");
        String password = scanner.nextLine();

        if (Objects.equals(username, "Admin") && Objects.equals(password, "Admin")) {
            System.out.println("Welcome Admin");
            adminScenario.AdminSession();
        } else {
            System.out.println("(LOGIN ERROR ) : Invalid Credentials");
            main.MainMenu();
        }
    }
}
