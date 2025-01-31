package com.practice;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateNumbers {

    public static void main(String[] args) {
        duplicateNumbers();
    }
    private static void duplicateNumbers() {
        // print duplicate numbers
        int[] a = {11, 4, 5, 2, 12, 34, 2, 11};
        // Arrays.stream(a).boxed().distinct().collect(Collectors.toList()).forEach(System.out::println);
        Map<Integer, Long> collect = Arrays.stream(a).boxed().collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting()));
        collect.entrySet().stream().filter(c -> c.getValue() > 1L)
                .forEach(c -> System.out.println("Duplicate number : " + c.getKey()));
    }
}
