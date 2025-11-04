package org.example.Junior_Exercises.Exercise5;

import java.util.Scanner;

public class Exercise_5_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String [] names = new String[5];

        for (int i = 0; i < names.length; i++){
            System.out.println("Enter name " + (i + 1) + ": ");
            names[i] = input.nextLine();
        }

        System.out.println("\nNames in reverse order: ");
        for (int i = names.length - 1; i >= 0; i--){
            System.out.println(names[i]);
        }
        input.close();
    }
}
