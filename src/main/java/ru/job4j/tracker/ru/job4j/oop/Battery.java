package ru.job4j.tracker.ru.job4j.oop;

public class Battery {
    private int load;

    public Battery() {
    }

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public void printInfo() {
        System.out.println("Load :" + load);
    }

    public static void main(String[] args) {
        Battery b1 = new Battery(10);
        Battery b2 = new Battery(5);
        b1.exchange(b2);
        b1.printInfo();
        b2.printInfo();
    }
}
