package org.example.Junior_Exercises.Exercise9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_9_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = in.nextLine();

        int age = 0;
        boolean validAge = false;

        while(!validAge){
            System.out.print("Enter student's age: ");
            try {
                age = in.nextInt();
                validAge = true;
            } catch (InputMismatchException e){
                System.out.println("Invalid input! Please enter a number for: ");
                in.nextLine();
            }
        }
        in.nextLine();

        System.out.print("Enter course: ");
        String course = in.nextLine();

        System.out.print("Enter registration ID: ");
        String regId = in.nextLine();

        Student s = new Student(name, age, course, regId);

        System.out.println("\n--- Output ---");

        System.out.println(s.introduce());

        System.out.println(s);

        in.close();
    }
}
