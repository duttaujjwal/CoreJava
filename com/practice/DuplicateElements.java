package com.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElements {
    public static void main(String[] args) {
        duplicateElements();
    }
    private static void duplicateElements() {
        // remove duplicate elements
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        Map<String, Long> collect = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> singleOccuranceList = collect.entrySet().stream().filter(item -> item.getValue() == 1L).map(Map.Entry::getKey).collect(Collectors.toList());
        singleOccuranceList.forEach(System.out::println);
    }
}
