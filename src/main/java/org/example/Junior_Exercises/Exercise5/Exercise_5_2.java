package org.example.Junior_Exercises.Exercise5;

import java.util.Scanner;

public class Exercise_5_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int[] numbers = new int[3];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++){
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
            sum += numbers[i];
        }

        int largest = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }
        double average = (double) sum / numbers.length;

        System.out.println("\nLargest number: " + largest);
        System.out.println("Average: " + average);

        input.close();
    }
}
