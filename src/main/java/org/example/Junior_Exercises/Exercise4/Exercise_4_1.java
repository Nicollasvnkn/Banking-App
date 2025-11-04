package org.example.Junior_Exercises.Exercise4;

import java.util.Scanner;

public class Exercise_4_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = "";
        while (!password.equals("secret")) {
            System.out.print("Enter password: ");
            password = input.nextLine();

            if (!password.equals("secret")) {
                System.out.print("Wrong password try again ");
            }
        }
        System.out.println("Access granted!");
        input.close();
    }
}
