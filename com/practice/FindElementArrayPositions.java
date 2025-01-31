package com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class FindElementArrayPositions {
    public static void main(String[] args) {
        findElementArrayPositions();
    }

    private static void findElementArrayPositions() {
        // find the element positions where the element is a subset of another element
        String[] arr1 = {"789", "abc", "xyz", "123"};
        String[] arr2 = {"xyz", "456"};
        String[] arr3 = {"abc", "123"};
        String[] arr4 = {"xyz"};
        String[] arr5 = {"789"};
        List<String[]> strings = Arrays.asList(arr1, arr2, arr3, arr4, arr5);

        // Convert arrays to sets for easy comparison
        List<Set<String>> sets = strings.stream()
                .map(arr -> new LinkedHashSet<>(Arrays.asList(arr)))
                .collect(Collectors.toList());

        List<Integer> resultIndexes = new ArrayList<>();

        for (int i = 0; i < sets.size(); i++) {
            Set<String> currentSet = sets.get(i);

            for (int j = 0; j < sets.size(); j++) {
                if (i != j && sets.get(j).containsAll(currentSet)) {
                    resultIndexes.add(i);
                    break; // No need to check further if a superset is found
                }
            }
        }

        System.out.println("Indexes of elements with a superset: " + resultIndexes);
    }
}
