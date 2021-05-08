package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String leftFirstElement = left.contains("/") ? left.substring(0, left.indexOf('/')) : left;
        String rightFirstElement = right.contains("/") ? right.substring(0, right.indexOf('/')) : right;
        int rsl = rightFirstElement.compareTo(leftFirstElement);
        if (rsl == 0) {
            return left.compareTo(right);
        }
        return rsl;
    }
}