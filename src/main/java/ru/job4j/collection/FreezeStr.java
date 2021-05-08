package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = false;
        Map<Character, Integer> leftMap = new HashMap<>();
        char[] leftCharArray = left.toCharArray();
        for (char ch : leftCharArray) {
            if (!leftMap.containsKey(ch)) {
                leftMap.put(ch, 1);
            } else {
                leftMap.put(ch, leftMap.get(ch) + 1);
            }
        }
        char[] rightCharArray = right.toCharArray();
        for (char ch : rightCharArray) {
            if (!leftMap.containsKey(ch)) {
                return false;
            } else if (leftMap.get(ch) == 1) {
                leftMap.remove(ch);
            } else {
                leftMap.put(ch, leftMap.get(ch) - 1);
            }
        }
        if (leftMap.isEmpty()) {
            rsl = true;
        }
        return rsl;
    }
}