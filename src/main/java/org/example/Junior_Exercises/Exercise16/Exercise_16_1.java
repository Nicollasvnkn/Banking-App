package org.example.Junior_Exercises.Exercise16;

import org.example.Junior_Exercises.Exercise10.BankAccount;
import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise15.SavingsAccount;
import org.example.Junior_Exercises.Exercise15.CheckingAccount;

import java.util.ArrayList;
import java.util.List;

public class Exercise_16_1 {
    public static void main(String[] args) {
        List<Reportable> items = new ArrayList<>();

        BankAccount std = new BankAccount("Alice", 500);
        SavingsAccount sav = new SavingsAccount("Bob", 1200, 0.03);
        CheckingAccount chk = new CheckingAccount("Carol", 300, 200);

        std.deposit(50);

        try {
            chk.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawl failed: " + e.getMessage());
        }

        items.add(std);
        items.add(sav);
        items.add(chk);

        System.out.println("---Reports---");
        for (Reportable r : items) {
            System.out.println(r.generateReport());
        }
    }
}
