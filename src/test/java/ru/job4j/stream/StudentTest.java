package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StudentTest {
    @Test
    public void studentTest() {
        List<Student> students = List.of(
                new Student(60, "Ivanov"),
                new Student(90, "Petrov"),
                new Student(40, "Sidorov"),
                new Student(60, "Ivanov"));
        Map<String, Student> rsl = Student.listToMap(students);
        assertThat(rsl.get("Ivanov").getScore(), is(60));
    }
}