package org.example.Junior_Exercises.Exercise3;
import java.util.Scanner;
public class Exercise_3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        String result = (number == 0)
            ? "The number is Zero"
            : (number % 2 == 0
              ? (number > 0 ? "Even and Positive" : "Even and Negative")
              : (number > 0 ? "Odd and Positive" : "Odd and Negative")
        );

        System.out.print(result);

        input.close();
    }
}
