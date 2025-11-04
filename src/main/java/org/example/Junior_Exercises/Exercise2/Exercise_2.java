package org.example.Junior_Exercises.Exercise2;
import java.util.Scanner;

public class Exercise_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Create Scanner

        //Ask for Name
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        //Ask for Age
        System.out.print("Enter your age: " );
        int age = input.nextInt();

        //Output result
        System.out.print("Hello " + name + ", you are " + age + " years old. ");

        input.close();
    }
}
