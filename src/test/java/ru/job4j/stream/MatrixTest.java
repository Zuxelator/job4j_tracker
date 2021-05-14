package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void matrixTest() {
        Integer[][] input = {{1, 2}, {3, 4}};
        List<Integer> out = Matrix.matrixToList(input);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(out, is(expected));
    }
}