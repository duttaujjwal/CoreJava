package com.practice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondHighestElement {

    public static void main(String[] args) {
        findSecondHighestElement();
    }

    private static void findSecondHighestElement() {
        // find the second-highest occurrence element
        String value = "aaaahhkjfljdsfjoisjhfdsgjdfkfdsklfjdsj";
        LinkedHashMap<Character, Long> collect = value.chars().mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        //   List<Map.Entry<Character, Long>> entryList = collect.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())).collect(Collectors.toList());
        List<Map.Entry<Character, Long>> entryList2 = collect.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .toList();
        System.out.println("the second-highest element is " + entryList2.get(1).getKey());
    }

}
