package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
            for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
                char leftChar = left.charAt(i);
                char rightChar = right.charAt(i);
                if (leftChar != rightChar) {
                    rsl = Character.compare(leftChar, rightChar);
                    break;
                }
            }
            rsl = rsl == 0 ? Integer.compare(left.length(), right.length()) : rsl;
        return rsl;
    }
}