package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDecreaseComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return Integer.compare(item2.getId(), item1.getId());
    }
}
