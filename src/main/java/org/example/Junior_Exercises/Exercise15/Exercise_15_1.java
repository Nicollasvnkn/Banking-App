package org.example.Junior_Exercises.Exercise15;


import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise17.Account;

import java.util.ArrayList;
import java.util.List;

public class Exercise_15_1 {
    public static void main(String [] args) throws Exception {
        List<Account> accounts = new ArrayList<>();

        SavingsAccount sa = new SavingsAccount("Alice", 1000, 0.03);
        CheckingAccount ca = new CheckingAccount("Bob", 300, 200);

        accounts.add(sa);
        accounts.add(ca);

        for (Account a : accounts) a.showBalance();

        sa.monthlyUpdate();
        try {
            ca.withdraw(450);
        } catch (InsufficientFundsException e) {
        System.out.println("Error" + e.getMessage());
        }

        for (Account a : accounts) a.showBalance();
    }
}
