package org.example.Junior_Exercises.Exercise4;

import java.util.Scanner;

public class Exercise_4_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu: ");
            System.out.println("1. Say Hello");
            System.out.println("2. Say Bye");
            System.out.println("0. Exit");
            System.out.println("Choose an option: ");
            option = input.nextInt();

            if (option == 1) {
                System.out.println("Hello!");
            } else if (option == 2) {
                System.out.println("Bye!");
            }else if (option == 0) {
                System.out.println("Exiting...");
            }else{
                System.out.println("Invalid option. Please choose 0, 1, or 2.");
            }
        }while (option != 0);

        System.out.println("Program ended.");
        input.close();
    }
}
