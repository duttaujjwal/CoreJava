package com.practice;

import java.util.Arrays;
import java.util.List;

public class NumbersStartingWith1 {
    public static void main(String[] args) {
        numbersStartingWith1();
    }
    private static void numbersStartingWith1() {
        // Given a list of integers, find out all the numbers starting with 1 using Stream functions
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList.stream().filter(i -> String.valueOf(i).startsWith("1")).forEach(System.out::println);
    }
}
