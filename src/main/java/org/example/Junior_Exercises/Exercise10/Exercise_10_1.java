package org.example.Junior_Exercises.Exercise10;

import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_10_1 {
    public static void main(String[] args) throws InsufficientFundsException {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter account owner's name: ");
        String name = input.nextLine();

        double initial = safeDoubleInput(input, "Enter initial balance: ");
        BankAccount account = new BankAccount(name, initial);

        int option = -1;

        do {
            System.out.println("\n---Menu---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show balance");
            System.out.println("0. Exit");

            option = safeIntInput(input, "Choose an option (0-3): ");

            if(option < 0 || option > 3){
                System.out.println("Invalid choice! Please select between 0 and 3");
                continue;
            }

            switch (option) {
                case 1 -> {
                    double dep = safeDoubleInput(input, "Enter deposit amount: ");
                    account.deposit(dep);
                }
                case 2 -> {
                    double w = safeDoubleInput(input, "Enter withdraw amount: ");
                    account.withdraw(w);
                }
                case 3 -> account.showBalance();
                case 0 -> System.out.print("Exiting...");
            }
        } while (option != 0);

        input.close();
        System.out.println("Program ended, thank you, " + account.getOwner() + "!");
    }

    private static int safeIntInput(Scanner input, String message) {
        double value = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(message);
            try {
                value = input.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid number! Please try again. ");
                input.nextLine();
            }
        }
        return (int) value;
    }

    private static double safeDoubleInput(Scanner input, String message) {
        double value = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(message);
            try {
                value = input.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid number! Please try again. ");
                input.nextLine();
            }
        }
        return value;
    }
}
