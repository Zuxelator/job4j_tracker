package ru.job4j.stream;

public class Flat {
    private short flatNumber;
    private double ceilingHeight;
    private byte roomCount;
    private double square;
    private boolean isInMoscow;
    private double price;
    private byte floor;

    static class  Builder {
        private short flatNumber;
        private double ceilingHeight;
        private byte roomCount;
        private double square;
        private double price;
        private byte floor;

        Builder buildFlatNumber(short flatNumber) {
            this.flatNumber = flatNumber;
            return this;
        }

        Builder buildCeilingHeight(double ceilingHeight) {
            this.ceilingHeight = ceilingHeight;
            return this;
        }

        Builder buildRoomCount(byte roomCount) {
            this.roomCount = roomCount;
            return this;
        }

        Builder buildSquare(double square) {
            this.square = square;
            return this;
        }

        Builder buildPrice(double price) {
            this.price = price;
            return this;
        }

        Builder buildFloor(byte floor) {
            this.floor = floor;
            return this;
        }

        Flat build() {
            Flat flat = new Flat();
            flat.flatNumber = flatNumber;
            flat.ceilingHeight = ceilingHeight;
            flat.roomCount = roomCount;
            flat.square = square;
            flat.price = price;
            flat.floor = floor;
            return flat;
        }

    }
}
