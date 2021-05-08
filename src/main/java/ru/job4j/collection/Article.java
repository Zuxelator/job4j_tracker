package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        origin = origin.replaceAll("\\p{P}", "");
        line = line.replaceAll("\\p{P}", "");
        HashSet<String> origHashSet = new HashSet<>(Arrays.asList(origin.split(" ")));
        HashSet<String> lineHashSet = new HashSet<>(Arrays.asList(line.split(" ")));
        for (String str : lineHashSet) {
            if (!origHashSet.contains(str)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}