package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Function {
    public static List<Double> diapason(int start, int finish, UnaryOperator<Double> interf) {
        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            rsl.add(interf.apply((double) i));
        }
        return rsl;
    }
}
