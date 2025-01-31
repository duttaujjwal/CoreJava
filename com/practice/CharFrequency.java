package com.practice;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharFrequency {
    public static void main(String[] args) {
        charFrequency();
    }
    private static void charFrequency() {
        // frequency of each character
        String inputString = "Java Concept Of The Day".toLowerCase();
        Map<String, Long> mapWithFreq = inputString.toLowerCase().chars().mapToObj(c -> (char) c + "")
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //mapWithFreq.forEach((key, value) -> System.out.println("Character " + key + " frequency : " + value));
        mapWithFreq.entrySet().stream().filter(item -> item.getKey() != " ").forEach(item ->
                System.out.println("Character " + item.getKey() + " frequency : " + item.getValue()));
    }
}
