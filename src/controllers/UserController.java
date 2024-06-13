package controllers;

import java.util.Scanner;

import services.UserService;

public class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        // Call register method from UserService directly
        if (userService.register(username, password, email)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. Username may already exist.");
        }
    }

    public void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userService.login(username, password)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }
}

