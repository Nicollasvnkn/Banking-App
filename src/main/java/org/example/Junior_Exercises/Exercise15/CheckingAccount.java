package org.example.Junior_Exercises.Exercise15;

import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise17.Account;
import org.example.Junior_Exercises.Exercise19.Taxable;

public class CheckingAccount extends Account implements Taxable {
    private final double overdraftLimit;

    public CheckingAccount(String owner, double initialBalance, double overdraftLimit) {
        super(owner, initialBalance);
        if (overdraftLimit < 0) throw new IllegalArgumentException("Overdraft must be >= 0");
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        double available = getBalance() + overdraftLimit;
        if (amount > available)
            throw new InsufficientFundsException("Exceeds overdraft limit. Available: $" + available);

        changeBalance(-amount);
        System.out.println("Withdraw $" + amount + " (checking, overdraft allowed)");
    }

    @Override
    public void monthlyUpdate() {
        if (getBalance() < 0) changeBalance(getBalance() * -0.01);
    }

    @Override
    public double calculateTax() {
        return getBalance() > 0 ? getBalance() * 0.02 : 0;
    }

    @Override
    public String getType() {
        return "Checking";
    }

    @Override
    public String generateReport() {
        return String.format("Checking(owner=%s, balance=%.2f, overdraft=%.2f)",
                getOwner(), getBalance(), getOverdraftLimit());
    }
}
