package org.example.Junior_Exercises.Exercise8;

import java.util.Scanner;

public class Exercise_8_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Car car = new Car();

        System.out.print("Enter the car brand: ");
        car.brand = input.nextLine();

        System.out.print("Enter the car color: ");
        car.color = input.nextLine();

        System.out.print("Enter the car year: ");
        car.year = input.nextInt();

        System.out.println("\nCar details: ");
        car.showDetails();
        car.start();

        input.close();
    }
}
