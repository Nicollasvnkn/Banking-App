package org.example.Junior_Exercises.Exercise19;

import org.example.Junior_Exercises.Exercise15.SavingsAccount;
import org.example.Junior_Exercises.Exercise15.CheckingAccount;
import org.example.Junior_Exercises.Exercise17.Account;

import java.util.ArrayList;
import java.util.List;

public class Exercise_19_1 {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("Alice", 2000, 0.04));
        accounts.add(new CheckingAccount("Bob", 1500, 300));
        accounts.add(new SavingsAccount("Charlie", 5000, 0.05));
        accounts.add(new CheckingAccount("Diana", 800, 200));

        System.out.println("=== Tax Report ===");
        for (Account acc : accounts) {
            System.out.println(acc);
            if (acc instanceof Taxable t) {
                double tax = t.calculateTax();
                System.out.printf("Tax owed: $%.2f%n", tax);
            } else {
                System.out.println("This account type is not taxable.");
            }
            System.out.println("------------------");
        }
    }
}
