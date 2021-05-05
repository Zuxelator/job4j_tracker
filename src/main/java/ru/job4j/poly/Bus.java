package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passangers(int passAmount) {
        System.out.println("Пассажиров в автобусе: " + passAmount);
    }

    @Override
    public double refuel(double fuel) {
        return fuel * 50;
    }
}
