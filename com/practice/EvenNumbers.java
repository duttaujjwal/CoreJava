package com.practice;

import java.util.stream.Stream;

public class EvenNumbers {
    public static void main(String[] args) {
        evenNumbers();
    }

    private static void evenNumbers() {
        // print even numbers
        Stream.of(1, 2, 3, 4).filter(integer -> integer % 2 == 0)
                .forEach(System.out::println);
    }
}
