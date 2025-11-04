package org.example.Junior_Exercises.Exercise8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_8_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        System.out.println("How many cars do you want to register: ");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Car #" + i + "----");
            Car car = new Car();

            System.out.print("Enter brand: ");
            car.brand = input.nextLine();

            System.out.print("Enter color: ");
            car.color = input.nextLine();

            System.out.print("Enter year: ");
            car.year = input.nextInt();
            input.nextLine();

            cars.add(car);
        }
        System.out.print("\n=== Registered Cars ===");
        for (Car c : cars) {
            c.showDetails();
            c.start();
        }

        input.close();
    }
}