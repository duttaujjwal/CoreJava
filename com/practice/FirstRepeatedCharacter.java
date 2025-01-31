package com.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        firstRepeatedCharacter();
    }
    private static void firstRepeatedCharacter() {
        // Given a String, find the first repeated character in it using Stream functions
        String input = "Java articles are Awesome";
        Map<Character, Long> collect = input.chars().mapToObj(c -> Character.toLowerCase((char) c)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Character characterLongEntry = collect.entrySet().stream().filter(value -> value.getValue() > 1L).findFirst().get().getKey();
        System.out.println(characterLongEntry);
    }
}
