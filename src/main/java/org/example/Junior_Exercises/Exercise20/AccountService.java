package org.example.Junior_Exercises.Exercise20;

import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.example.Junior_Exercises.Exercise17.Account;

import java.util.*;

public class AccountService {
    private final List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void add(Account account) {
        accounts.add(account);
    }

    public void deposit(Account acc, double amount) {
        acc.deposit(amount);
    }

    public void withdraw(Account acc, double amount) throws InsufficientFundsException  {
        acc.withdraw(amount);
    }

    public void transfer(Account from, Account to, double amount) throws InsufficientFundsException {
        from.withdraw(amount);
        to.deposit(amount);
    }


    public List<Account> searchByOwner(String name) {
        return accounts.stream()
                .filter(a -> a.getOwner().equalsIgnoreCase(name))
                .toList();
    }


}
