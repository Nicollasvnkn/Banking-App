package org.example.Junior_Exercises.Exercise14;

import org.example.Junior_Exercises.Exercise10.BankAccount;
import org.example.Junior_Exercises.Exercise12.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;
    private String ownerName;

    @BeforeEach
    void setup() {
        ownerName = "User_" + System.currentTimeMillis();
        account = new BankAccount(ownerName, 100.0);
    }

    @Test
    void depositShouldIncreaseBalance() {
        account.deposit(50);
        assertEquals(150.0, account.getBalance(), 0.01);
    }

    @Test
    void depositShouldThrowExceptForNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
    }

    @Test
    void withdrawShouldDecreaseBalance() throws InsufficientFundsException {
        account.withdraw(40);
        assertEquals(60.0, account.getBalance(), 0.01);
    }

    @Test
    void withdrawShouldThrowExceptionInsufficientFunds() {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(200));
    }

    @Test
    void withdrawShouldThrowExceptionForNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5));
    }

    @Test
    void getOwnerShouldReturnCorrectName() {
        assertEquals(ownerName, account.getOwner());
    }

    @Test
    void initialBalanceShouldBeSetCorrectly() {
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    void bankAccountGeneratesReport(){
        BankAccount a = new BankAccount(ownerName, 100);
        String report = a.generateReport();
        assertTrue(report.contains(ownerName));
        assertTrue(report.contains("100.00") || report.contains("100"));

    }
}
