package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class ComparatorTest {
    @Test
    public void jobIncreseByNameTest() {
        ArrayList<Job> array = new ArrayList<>();
        array.add(new Job("aac", 10));
        array.add(new Job("aaa", 5));
        array.add(new Job("aab", 2));
        Collections.sort(array, new JobIncByName());
        Assert.assertThat(array.get(0).getName(), is("aaa"));
    }

    @Test
    public void jobDescByNameTest() {
        ArrayList<Job> array = new ArrayList<>();
        array.add(new Job("aaa", 5));
        array.add(new Job("aac", 10));
        array.add(new Job("aab", 2));
        Collections.sort(array, new JobDescByName());
        Assert.assertThat(array.get(0).getName(), is("aac"));
    }

    @Test
    public void jobIncreseByPriorityTest() {
        ArrayList<Job> array = new ArrayList<>();
        array.add(new Job("aac", 10));
        array.add(new Job("aaa", 5));
        array.add(new Job("aab", 2));
        Collections.sort(array, new JobIncByPriority());
        Assert.assertThat(array.get(0).getName(), is("aab"));
    }

    @Test
    public void jobDescByPriorityTest() {
        ArrayList<Job> array = new ArrayList<>();
        array.add(new Job("aaa", 5));
        array.add(new Job("aac", 10));
        array.add(new Job("aab", 2));
        Collections.sort(array, new JobDescByPriority());
        Assert.assertThat(array.get(0).getName(), is("aac"));
    }

    @Test
    public void jobDescByPriorityAndDescByNameTest() {
        ArrayList<Job> array = new ArrayList<>();
        array.add(new Job("aaa", 5));
        array.add(new Job("aac", 10));
        array.add(new Job("aab", 2));
        array.add(new Job("aaa", 2));
        Collections.sort(array, new JobDescByPriority().thenComparing(new JobDescByName()));
        Assert.assertThat(array.get(3).getName(), is("aaa"));
    }

    @Test
    public void jobIncByPriorityAndDescByNameTest() {
        ArrayList<Job> array = new ArrayList<>();
        array.add(new Job("aaa", 5));
        array.add(new Job("aac", 10));
        array.add(new Job("aab", 2));
        array.add(new Job("aaa", 2));
        Collections.sort(array, new JobIncByPriority().thenComparing(new JobDescByName()));
        Assert.assertThat(array.get(0).getName(), is("aab"));
    }

}