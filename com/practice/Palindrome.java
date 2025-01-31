package com.practice;

import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String[] args) {
        palindrome();
    }
    private static void palindrome() {
        // find if the word is a palindrome
        String word = "madam";
        if (IntStream.range(0, word.length() / 2).allMatch(i -> word.charAt(i) == word.charAt(word.length() - i - 1)))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}
