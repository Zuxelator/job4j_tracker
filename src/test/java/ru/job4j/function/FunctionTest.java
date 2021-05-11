package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = Function.diapason(2, 4, x -> Math.pow(x, 2) + 5);
        List<Double> expected = Arrays.asList(9D, 14D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = Function.diapason(3, 7, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(27D, 81D, 243D, 729D);
        assertThat(result, is(expected));
    }

}