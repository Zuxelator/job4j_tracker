package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : this.list) {
           list.add(fun.apply(integer));
        }
        return new EasyStream(list);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : this.list) {
            if (fun.test(integer)) {
                list.add(integer);
            }
        }
        return new EasyStream(list);
    }

    public List<Integer> collect() {
        return new ArrayList<>(list);
    }
}