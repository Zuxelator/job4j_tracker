package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String newLeft = left.substring(0, left.indexOf('.'));
        String newRight = right.substring(0, right.indexOf('.'));
        return Integer.compare(Integer.parseInt(newLeft), Integer.parseInt(newRight));
    }
}