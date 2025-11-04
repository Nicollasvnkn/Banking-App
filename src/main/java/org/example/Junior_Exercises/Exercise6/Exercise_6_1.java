package org.example.Junior_Exercises.Exercise6;

import java.util.Locale;
import java.util.Scanner;

public class Exercise_6_1 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = input.nextLine().toLowerCase();

        int count = 0;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i'|| c == 'o' || c == 'u'){
                count++;
            }
        }
        System.out.println("Number of vowels: " + count);
        input.close();
    }
}
