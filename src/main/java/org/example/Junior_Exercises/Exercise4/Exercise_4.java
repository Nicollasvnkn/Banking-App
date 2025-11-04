package org.example.Junior_Exercises.Exercise4;
import java.util.stream.IntStream;

public class Exercise_4 {
    public static void main (String[] args){
        //1 to 100
        IntStream.rangeClosed(1, 100).forEach(System.out::println);

        // Multiplication table of 7
        IntStream.range(1,10)
                .forEach(i -> System.out.println("7 x " + i + " = " + (7 * i)));

        //Sum form 1 to N (example N=5)
        int N = 5;
        int sum = IntStream.rangeClosed(1, N).sum();
        System.out.println("The sum from 1 to " + N + " is: " + sum);

    }
}
