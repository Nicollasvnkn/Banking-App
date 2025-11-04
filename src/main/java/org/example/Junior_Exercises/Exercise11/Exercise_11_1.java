package org.example.Junior_Exercises.Exercise11;

import org.example.Junior_Exercises.Exercise10.BankAccount;
import org.example.Junior_Exercises.Exercise12.AccountRepository;
import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise13.JsonAccountRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_11_1 {

    public static void main(String[] args) {
        JsonAccountRepository jsonRepo = new JsonAccountRepository("accounts.json");
        AccountRepository csvRepo = new AccountRepository("accounts.csv");

        Scanner in = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();
        int selected = -1;

        int option = -1;
        do {
            System.out.println("\n--- Bank System ---");
            System.out.println("1. Create account");
            System.out.println("2. List accounts");
            System.out.println("3. Select account");
            System.out.println("4. Deposit (selected)");
            System.out.println("5. Withdraw (selected)");
            System.out.println("6. Show balance (selected)");
            System.out.println("7. Transfer between accounts");
            System.out.println("8. Save accounts (JSON)");
            System.out.println("9. Load accounts (JSON)");
            System.out.println("10. Save accounts (CSV)");
            System.out.println("11. Load accounts (CSV)");
            System.out.println("12. Exit");

            try {
                option = readInt(in, "Choose an option (1-10): ");

                if (option < 1 || option > 12) {
                    System.out.println("Invalid choice! Select between 1 and 12.");
                    continue;
                }

                switch (option) {
                    case 1 -> {
                        System.out.print("Owner name: ");
                        String name = in.nextLine();
                        double initial = readDouble(in, "Initial balance: ");
                        accounts.add(new BankAccount(name, initial));
                        System.out.println("Account created for " + name + " (index " + accounts.size() + ").");
                    }

                    case 2 -> {
                        if (accounts.isEmpty()) {
                            System.out.println("No accounts yet.");
                        } else {
                            System.out.println("\n# | Owner | Balance");
                            for (int i = 0; i < accounts.size(); i++) {
                                BankAccount a = accounts.get(i);
                                System.out.printf("%d | %s | $%.2f%n", i + 1, a.getOwner(), a.getBalance());
                            }
                        }
                    }

                    case 3 -> {
                        if (accounts.isEmpty()) {
                            System.out.println("No accounts to select. Create one first.");
                            break;
                        }
                        int idx1 = readInt(in, "Enter account index to select (1.." + accounts.size() + "): ");
                        int idx = idx1 - 1; // convert to 0-based

                        if (!validIndex(idx, accounts)) {
                            System.out.println("Invalid index.");
                        } else {
                            selected = idx;
                            System.out.println("Selected account #" + (selected + 1) +
                                    " (" + accounts.get(selected).getOwner() + ")");
                        }
                    }

                    case 4 -> {
                        if (!hasSelection(selected, accounts)) break;
                        double amt = readDouble(in, "Deposit amount: ");
                        try {
                            accounts.get(selected).deposit(amt);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    case 5 -> {
                        if (!hasSelection(selected, accounts)) break;
                        double amt = readDouble(in, "Withdraw amount: ");
                        try {
                            accounts.get(selected).withdraw(amt);
                        } catch (IllegalArgumentException | InsufficientFundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    case 6 -> {
                        if (!hasSelection(selected, accounts)) break;
                        accounts.get(selected).showBalance(); // your method name is showbalance()
                    }

                    case 7 -> {
                        if (accounts.size() < 2) {
                            System.out.println("Need at least two accounts to transfer.");
                            break;
                        }

                        int from1 = readInt(in, "From account index (1.." + accounts.size() + "): ");
                        int to1   = readInt(in, "To account index (1.." + accounts.size() + "): ");
                        double amt = readDouble(in, "Amount to transfer: ");

                        int from = from1 - 1;
                        int to   = to1 - 1;

                        if (!validIndex(from, accounts) || !validIndex(to, accounts)) {
                            System.out.println("Invalid index(es).");
                            break;
                        }
                        if (from == to) {
                            System.out.println("Cannot transfer to the same account.");
                            break;
                        }
                        if (amt <= 0) {
                            System.out.println("Invalid amount.");
                            break;
                        }

                        BankAccount src = accounts.get(from);
                        BankAccount dst = accounts.get(to);

                        try {
                            src.withdraw(amt);
                            dst.deposit(amt);
                            System.out.printf("Transferred $%.2f from #%d to #%d%n", amt, from1, to1);
                        } catch (IllegalArgumentException | InsufficientFundsException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    case 8 -> {
                        try {
                            jsonRepo.save(accounts);
                            System.out.println("Saved" + accounts.size() + " account(s) to accounts.json");
                        } catch (IOException e) {
                            System.out.println("Failed to save JSON: " + e.getMessage());
                        }
                    }

                    case 9 -> {
                        try {
                            accounts = jsonRepo.load();
                            selected = -1;
                            System.out.println("Loaded" + accounts.size() + " account(s) to accounts.json");
                        } catch (IOException e) {
                            System.out.println("Failed to save JSON: " + e.getMessage());
                        }
                    }

                    case 10 -> {
                        try {
                            csvRepo.save(accounts);
                            System.out.println("Exported" + accounts.size() + " account(s) to accounts.csv");
                        } catch (IOException e) {
                            System.out.println("Failed to export CSV: " + e.getMessage());
                        }
                    }

                    case 11 -> {
                        try {
                            accounts = csvRepo.load();
                            selected = -1;
                            System.out.println("Imported " + accounts.size() + " accounts(s) from accounts.csv");
                        } catch (IOException e) {
                            System.out.println("Failed to import CSV: " + e.getMessage());
                        }
                    }

                    case 12 -> System.out.println("Exiting...");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input (expected a number). Try again.");
                option = -1; // keep loop going
            }
        } while (option != 10);

        in.close();
        System.out.println("Program ended.");
    }

    // ---------- helpers ----------
    private static int readInt(Scanner in, String prompt) throws NumberFormatException {
        System.out.print(prompt);
        return Integer.parseInt(in.nextLine().trim());
    }

    private static double readDouble(Scanner in, String prompt) throws NumberFormatException {
        System.out.print(prompt);
        return Double.parseDouble(in.nextLine().trim());
    }

    private static boolean hasSelection(int selected, List<BankAccount> list) {
        if (selected < 0 || selected >= list.size()) {
            System.out.println("No account selected. Use option 3 first.");
            return false;
        }
        return true;
    }

    private static boolean validIndex(int i, List<BankAccount> list) {
        return i >= 0 && i < list.size();
    }
}