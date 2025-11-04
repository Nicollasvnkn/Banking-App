package org.example.Junior_Exercises.Exercise17;

import org.example.Junior_Exercises.Exercise10.BankAccount;
import org.example.Junior_Exercises.Exercise15.CheckingAccount;
import org.example.Junior_Exercises.Exercise15.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

public class Exercise_17_1 {
    public static void main (String[] args) throws Exception {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new BankAccount("StdUser", 500));
        accounts.add(new SavingsAccount("Saver", 1000, 0.03));
        accounts.add(new CheckingAccount("Checker", 300, 200));

        for (Account a : accounts) a.monthlyUpdate();

        System.out.println("--- Reports ---");
        for (Account a : accounts){
            System.out.println(a.generateReport());
        }
    }
}
