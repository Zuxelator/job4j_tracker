package ru.job4j.stream;

import ru.job4j.oop.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCards {
    public static void main(String[] args) {
        List<Card> streamCards = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                    .map(value -> new Card(suit, value)))
                .collect(Collectors.toList());
    }
}
