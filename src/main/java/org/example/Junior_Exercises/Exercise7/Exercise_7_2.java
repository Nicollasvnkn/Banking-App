package org.example.Junior_Exercises.Exercise7;

import java.util.Scanner;

public class Exercise_7_2 {
    static boolean isPalindrome (String word){
        word = word.toLowerCase();
        StringBuilder reversed = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed.append(word.charAt(i));
        }

        return word.contentEquals(reversed);
    }

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = input.nextLine();

        if (isPalindrome(word)){
            System.out.println("it's a palindrome!");
        } else {
            System.out.println("Not a palindrome!");
        }
        input.close();
    }
}
