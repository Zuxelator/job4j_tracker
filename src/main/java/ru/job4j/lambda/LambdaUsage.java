package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("asd", "ss", "ssdsdas", "dasd"));
        Comparator<String> descComp = (left, right) -> {
            System.out.println("compare - " + right + " : " + left);
            return Integer.compare(right.length(), left.length());
        };
        System.out.println(arr);
        Collections.sort(arr, descComp);
        System.out.println(arr);
    }
}
