package ru.job4j.tracker.ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
        Vehicle airbus = new Plane();
        Vehicle boeing = new Plane();
        Vehicle electrovoz = new Train();
        Vehicle parovoz = new Train();
        Vehicle ikarus = new Bus();
        Vehicle liaz = new Bus();
        Vehicle[] arr = {airbus, boeing, electrovoz, parovoz, ikarus, liaz};
        for (int i = 0; i < arr.length; i++) {
            arr[i].move();
        }
    }
}
