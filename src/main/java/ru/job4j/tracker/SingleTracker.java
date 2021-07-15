package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private static MemTracker memTracker = new MemTracker();

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
        return memTracker.add(item);
    }

    public static Item findById(int id) {
        return memTracker.findById(id);
    }

    public static List<Item> findAll() {
        return memTracker.findAll();
    }

    public static List<Item> findByName(String key) {
        return memTracker.findByName(key);
    }

    public static boolean replace(int id, Item item) {
        return memTracker.replace(id, item);
    }

    public static boolean delete(int id) {
        return memTracker.delete(id);
    }

    /* Остальные методы из класса MemTracker. */
}