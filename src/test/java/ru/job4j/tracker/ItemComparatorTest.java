package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class ItemComparatorTest {

    @Test
    public void increaseCompare() {
        Item item1 = new Item("bug");
        item1.setId(3);
        Item item2 = new Item("bug2");
        item2.setId(1);
        List<Item> arr = new ArrayList<>();
        arr.add(item1);
        arr.add(item2);
        Collections.sort(arr, new ItemIncreaseComparator());
        Assert.assertThat(arr.get(0).getName(), is("bug2"));
    }

    @Test
    public void decreaseCompare() {
        Item item1 = new Item("bug");
        item1.setId(3);
        Item item2 = new Item("bug2");
        item2.setId(1);
        List<Item> arr = new ArrayList<>();
        arr.add(item2);
        arr.add(item1);
        Collections.sort(arr, new ItemDecreaseComparator());
        Assert.assertThat(arr.get(0).getName(), is("bug"));
    }
}