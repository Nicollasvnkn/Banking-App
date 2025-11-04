package org.example.Junior_Exercises.Exercise17;

import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise16.Reportable;

import java.time.LocalDateTime;

public abstract class Account implements Reportable {
    public final String owner;
    public double balance;
    public final LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    protected Account(String owner, double initialBalance) {
        if (owner == null || owner.isBlank()) throw new IllegalArgumentException("Owner required");
        this.owner = owner;
        this.balance = initialBalance;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public String getOwner() { return owner; }
    public Double getBalance() { return balance; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    protected void changeBalance(double delta) {
        this.balance += delta;
        this.updatedAt = LocalDateTime.now();
    }

    public void deposit(double amount){
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        changeBalance(amount);
        System.out.println("Deposited $" + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds. Balance: $" + balance);
        changeBalance(-amount);
        System.out.println("withdrew $" + amount);
    }

    public abstract void monthlyUpdate();

    public abstract String getType();

    public void showBalance(){
        System.out.printf("Current balance: $%.2f%n", balance);
    }

    @Override
    public String toString() {
        return String.format("[%s] Owner: %s, Balance: $%.2f", getType(), getOwner(), getBalance());
    }

    @Override
    public String generateReport() {
        return String.format("%s(owner=%s, balance=%.2f, createdAt=%s, updatedAt=%s)",
                getType(), getOwner(), getBalance(), getCreatedAt(), getUpdatedAt());
    }
}
