package org.example.Junior_Exercises.Exercise15;

import org.example.Junior_Exercises.Exercise17.Account;
public class SavingsAccount extends Account {
    private final double interestRate;

    public SavingsAccount(String owner, double initialBalance, double interestRate) {
        super(owner, initialBalance);
        if (interestRate < 0) throw new IllegalArgumentException("Interest rate must be >=0");
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest(){
        double interest = getBalance() * interestRate;
        if (interest > 0) deposit(interest);
    }

    @Override
    public String getType() {
        return "Saving";
    }

    @Override
    public void monthlyUpdate() {
        double interest = getBalance() * interestRate;
        if (interest > 0) deposit(interest);
    }
    @Override
    public String generateReport() {
        return String.format("Savings(owner=%s, balance=%.2f, rate=%.2f%%)",
                getOwner(), getBalance(), getInterestRate()*100);
    }
}
