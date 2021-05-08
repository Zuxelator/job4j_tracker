package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> leftMap = new HashMap<>();
        char[] leftCharArray = left.toCharArray();
        for (char ch : leftCharArray) {
            if (!leftMap.containsKey(ch)) {
                leftMap.put(ch, 1);
            } else {
                leftMap.put(ch, leftMap.get(ch) + 1);
            }
        }
        Map<Character, Integer> rightMap = new HashMap<>();
        char[] rightCharArray = right.toCharArray();
        for (char ch : rightCharArray) {
            if (!rightMap.containsKey(ch)) {
                rightMap.put(ch, 1);
            } else {
                rightMap.put(ch, rightMap.get(ch) + 1);
            }
        }
        return leftMap.equals(rightMap);
    }
}