package org.example.Junior_Exercises.Exercise20;

import org.example.Junior_Exercises.Exercise10.BankAccount;
import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise15.CheckingAccount;
import org.example.Junior_Exercises.Exercise15.SavingsAccount;
import org.example.Junior_Exercises.Exercise17.Account;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BankingApp {
    private static final Scanner in = new Scanner(System.in);

    // Services
    private static final AccountService accountService = new AccountService();
    private static final PersistenceService persistenceService = new PersistenceService();
    private static final TaxService taxService = new TaxService();

    public static void main(String[] args) {
        loadAccounts();

        int option;
        do {
            printMenu();
            option = readInt("Choose an option: ");
            handleOption(option);
        } while (option != 0);

        saveAccounts();
        System.out.println("Program Ended");
    }

    private static void printMenu() {
        System.out.println("\n=== Bank System ===");
        System.out.println("1. Create Account");
        System.out.println("2. List Accounts");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. Sort by Balance");
        System.out.println("7. Search by Owner");
        System.out.println("8. Tax Report");
        System.out.println("9. Save to JSON");
        System.out.println("0. Exit");
    }

    private static void handleOption(int option) {
        switch (option) {
            case 1 -> createAccount();
            case 2 -> listAccounts();
            case 3 -> deposit();
            case 4 -> withdraw();
            case 5 -> transfer();
            case 6 -> sortByBalance();
            case 7 -> searchByOwner();
            case 8 -> taxReport();
            case 9 -> saveAccounts();
            case 0 -> System.out.println("Exiting...");
            default -> System.out.println("Invalid choice!");
        }
    }

    // --- Actions ---

    private static void createAccount() {
        System.out.println("\nChoose type: 1=Bank, 2=Savings, 3=Checking");
        int type = readInt("Type: ");
        System.out.print("Owner name: ");
        String owner = in.nextLine();
        double initial = readDouble("Initial balance: ");

        // Construct using your existing classes
        Account acc = switch (type) {
            case 2 -> new SavingsAccount(owner, initial, 0.03);
            case 3 -> new CheckingAccount(owner, initial, 200);
            default -> new BankAccount(owner, initial);
        };

        // Register through AccountService
        accountService.add(acc);
        System.out.println("Account created for " + owner);
    }

    private static void listAccounts() {
        List<Account> accounts = accountService.getAccounts();
        System.out.println("\n=== Accounts ===");
        if (accounts.isEmpty()) System.out.println("(none)");
        else {
            for (int i = 0; i < accounts.size(); i++) {
                System.out.printf("[%d] %s%n", i + 1, accounts.get(i));
            }
        }
    }

    private static void deposit() {
        Account acc = pickAccount();
        if (acc == null) return;
        double amt = readDouble("Deposit amount: ");
        accountService.deposit(acc, amt);
        System.out.println("Deposited $" + amt + " into " + acc.getOwner());
    }

    private static void withdraw() {
        Account acc = pickAccount();
        if (acc == null) return;
        double amt = readDouble("Withdraw amount: ");
        try {
            accountService.withdraw(acc, amt);
            System.out.println("Withdrawn $" + amt + " from " + acc.getOwner());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void transfer() {
        Account from = pickAccount("From index: ");
        Account to = pickAccount("To index: ");
        if (from == null || to == null || from == to) return;
        double amt = readDouble("Amount: ");
        try {
            // Ensure AccountService.transfer DEPOSITS into 'to' (not withdraw)
            accountService.transfer(from, to, amt);
            System.out.printf("Transferred $%.2f from %s to %s%n", amt, from.getOwner(), to.getOwner());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sortByBalance() {
        // Use your existing sort in AccountService (or sort here for demo)
        accountService.getAccounts().sort(Comparator.comparing(Account::getBalance).reversed());
        System.out.println("\n=== Sorted by Balance ===");
        listAccounts();
    }

    private static void searchByOwner() {
        System.out.print("Enter name to search: ");
        String name = in.nextLine();
        List<Account> results = accountService.searchByOwner(name);
        if (results.isEmpty()) {
            System.out.println("(no matches)");
        } else {
            System.out.println("\n=== Search Results ===");
            results.forEach(System.out::println);
        }
    }

    private static void taxReport() {
        // Delegate to TaxService (uses instanceof Taxable internally as you implemented)
        taxService.generateTaxReport(accountService.getAccounts());
    }

    // --- Helpers ---

    private static Account pickAccount() {
        return pickAccount("Enter account index: ");
    }

    private static Account pickAccount(String prompt) {
        List<Account> accounts = accountService.getAccounts();
        listAccounts();
        int idx = readInt(prompt);
        if (idx < 1 || idx > accounts.size()) {
            System.out.println("Invalid index");
            return null;
        }
        return accounts.get(idx - 1);
    }

    private static void loadAccounts() {
        try {
            List<Account> loaded = persistenceService.loadFromJson();
            accountService.getAccounts().clear();
            for (Account a : loaded) {
                accountService.add(a);
            }
            System.out.println("Loaded " + loaded.size() + " accounts from JSON");
        } catch (IOException e) {
            System.out.println("️No existing file found. Starting fresh.");
        }
    }

    private static void saveAccounts() {
        try {
            persistenceService.saveToJson(accountService.getAccounts());
            System.out.println("Saved " + accountService.getAccounts().size() + " accounts to JSON");
        } catch (IOException e) {
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    private static int readInt(String msg) {
        System.out.print(msg);
        while (!in.hasNextInt()) {
            System.out.print("Invalid number, try again: ");
            in.next();
        }
        int val = in.nextInt();
        in.nextLine(); // consume newline
        return val;
    }

    private static double readDouble(String msg) {
        System.out.print(msg);
        while (!in.hasNextDouble()) {
            System.out.print("Invalid amount, try again: ");
            in.next();
        }
        double val = in.nextDouble();
        in.nextLine(); // consume newline
        return val;
    }
}
