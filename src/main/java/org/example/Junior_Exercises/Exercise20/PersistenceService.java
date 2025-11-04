package org.example.Junior_Exercises.Exercise20;

import org.example.Junior_Exercises.Exercise10.BankAccount;
import org.example.Junior_Exercises.Exercise12.AccountRepository;
import org.example.Junior_Exercises.Exercise13.JsonAccountRepository;
import org.example.Junior_Exercises.Exercise17.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenceService {
    private final JsonAccountRepository jsonRepo = new JsonAccountRepository("accounts.json");
    private final AccountRepository csvRepo = new AccountRepository("accounts.csv");

    // ---- JSON ----
    public void saveToJson(List<Account> accounts) throws IOException {
        List<BankAccount> bankAccounts = new ArrayList<>(accounts.size());
        for (Account a : accounts) {
            bankAccounts.add((BankAccount) a);
        }
        jsonRepo.save(bankAccounts);
    }

    public List<Account> loadFromJson() throws IOException {
        List<BankAccount> loaded = jsonRepo.load();
        // Upcast to List<Account> via copy
        return new ArrayList<>(loaded);
    }

    // ---- CSV ----
    public void saveToCsv(List<Account> accounts) throws IOException {
        List<BankAccount> bankAccounts = new ArrayList<>(accounts.size());
        for (Account a : accounts) {
            bankAccounts.add((BankAccount) a);
        }
        csvRepo.save(bankAccounts);
    }

    public List<Account> loadFromCsv() throws IOException {
        List<BankAccount> loaded = csvRepo.load();
        return new ArrayList<>(loaded);
    }
}
