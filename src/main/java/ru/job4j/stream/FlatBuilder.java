package ru.job4j.stream;

public class FlatBuilder {
    public static void main(String[] args) {
        Flat flat = new Flat.Builder().buildFlatNumber((short) 5)
                .buildCeilingHeight(2.50)
                .buildPrice(7000000)
                .buildSquare(45)
                .buildFloor((byte) 10)
                .buildRoomCount((byte) 1)
                .build();
    }
}
