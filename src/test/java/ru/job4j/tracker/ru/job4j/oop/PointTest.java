package ru.job4j.tracker.ru.job4j.oop;

import org.junit.Test;

import org.junit.Assert;

public class PointTest {

    @Test
    public void when00to20then2() {
        int expected = 2;
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 0);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when11to22then141() {
        double expected = 1.41;
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when32to15then3605() {
        double expected = 3.605;
        int x1 = 3;
        int y1 = 2;
        int x2 = 1;
        int y2 = 5;
        Point point1 = new Point(3, 2);
        Point point2 = new Point(1, 5);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when22to22then0() {
        double expected = 0;
        int x1 = 2;
        int y1 = 2;
        int x2 = 2;
        int y2 = 2;
        Point point1 = new Point(2, 2);
        Point point2 = new Point(2, 2);
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }
}