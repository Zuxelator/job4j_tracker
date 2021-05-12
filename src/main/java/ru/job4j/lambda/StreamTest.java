package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, -2, 10, 5, -8, 15);
        List<Integer> rsl = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(rsl);
    }
}
