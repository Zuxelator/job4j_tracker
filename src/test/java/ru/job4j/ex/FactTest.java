package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNlessZeroThenIllegalArgEx() {
        new Fact().calc(-5);
    }
}