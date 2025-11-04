package org.example.Junior_Exercises.Exercise10;

import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise16.Reportable;
import org.example.Junior_Exercises.Exercise17.Account;

import java.time.LocalDateTime;

public class BankAccount extends Account {

    //Constructor
    public BankAccount(String owner, double initalBalance){
        super(owner, initalBalance);
    }

    //Deposit
    public void deposit(double amount){
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive. ");
        balance += amount;
        System.out.println("Deposited $" + amount);
    }

    //Withdraw
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive.");
        if(amount > balance){
            throw new InsufficientFundsException(
                    "Insufficient funds. Balance: $" + balance + ", requested: $" + amount
            );
        }
        balance -= amount;
        System.out.println("Withdrew $" + amount);
    }

    @Override
    public void monthlyUpdate() {

    }


    protected void changeBalance(double delta) {
        this.balance += delta;
        this.updatedAt = java.time.LocalDateTime.now();
    }

    @Override
    public String generateReport() {
        String created = (getCreatedAt() != null) ? getCreatedAt().toString() : "-";
        String updated = (getUpdatedAt() != null) ? getUpdatedAt().toString() : "-";
        return String.format(
                "Account(owner=%s, balance=%.2f, createdAt=%s, updatedAt=%s)",
                getOwner(), getBalance(), created, updated
        );
    }

    @Override
    public String getType() {
        return "Account";
    }
}
