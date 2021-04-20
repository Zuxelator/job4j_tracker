package ru.job4j.tracker;

import java.util.Arrays;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private static Tracker tracker = new Tracker();

    /* реализовать singleton */

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public static Item add(Item item) {
        return tracker.add(item);
    }

    public static Item findById(int id) {
        return tracker.findById(id);
    }

    public static Item[] findAll() {
        return tracker.findAll();
    }

    public static Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public static boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public static boolean delete(int id) {
        return tracker.delete(id);
    }

    /* Остальные методы из класса Tracker. */
}