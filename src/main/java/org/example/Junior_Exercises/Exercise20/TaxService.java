package org.example.Junior_Exercises.Exercise20;

import org.example.Junior_Exercises.Exercise17.Account;
import org.example.Junior_Exercises.Exercise19.Taxable;

import java.util.List;

public class TaxService {

    public void generateTaxReport(List<Account> accounts) {
        System.out.println("\n=== Tax Report ===");
        for (Account acc : accounts) {
            if (acc instanceof Taxable t) {
                double tax = t.calculateTax();
                System.out.printf("%s owes $%.2f in taxes%n", acc.getOwner(), tax);
            } else {
                System.out.printf("%s is not taxable%n", acc.getOwner());
            }
        }
    }
}
