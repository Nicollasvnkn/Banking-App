package org.example.Junior_Exercises.Exercise18;

import org.example.Junior_Exercises.Exercise15.SavingsAccount;
import org.example.Junior_Exercises.Exercise15.CheckingAccount;
import org.example.Junior_Exercises.Exercise17.Account;

import java.util.*;

public class Exercise_18_1 {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("Alice", 1200, 0.03));
        accounts.add(new CheckingAccount("Bob", 500, 200));
        accounts.add(new SavingsAccount("Charlie", 3000, 0.05));
        accounts.add(new CheckingAccount("Diana", 250, 100));

        System.out.println("=== All Accounts ===");
        accounts.forEach(System.out::println);

        //Owner
        System.out.println("\n=== Sorted by Owner ===");
        accounts.sort(Comparator.comparing(Account::getOwner));
        accounts.forEach(a -> System.out.println(a.getOwner() + " - $" + a.getBalance()));


        //Sort by Balance
        System.out.println("\n=== Sorted by Balance (High -> Low) ===");
        accounts.sort(Comparator.comparing(Account::getBalance).reversed());
        accounts.forEach(a -> System.out.printf("%s: $%.2f%n", a.getOwner(), a.getBalance()));

        //Search by Owner
        String search = "";
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter owner name to search (or Press enter to skip)");
        try {
            if (in.hasNextLine()) {
                search = in.nextLine().trim();
            }
        } catch (Exception ignored) {
            // no console available; skip search
        }

        if (!search.isEmpty()) {
            String finalSearch = search;
            List<Account> found = accounts.stream()
                    .filter(a -> a.getOwner().equalsIgnoreCase(finalSearch))
                    .toList();

            if (found.isEmpty()) {
                System.out.println("No account for: " + search);
            } else {
                System.out.println("Found accounts:");
                found.forEach(a -> System.out.printf("%s: $%.2f%n", a.getOwner(), a.getBalance()));
            }
        } else {
            System.out.println("Search skipped.");
        }


        System.out.println("\nTop richest account:");
        accounts.stream()
                .max(Comparator.comparing(Account::getBalance))
                .ifPresent(a -> System.out.printf("%s with $%.2f%n", a.getOwner(), a.getBalance()));
    }
}
