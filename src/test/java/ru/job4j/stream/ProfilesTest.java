package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void profileTest() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Tverskaya", 10, 1)),
                new Profile(new Address("Moscow", "Chertanovskaya", 1, 12))

        );

        List<Address> rsl = Profiles.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Tverskaya", 10, 1));
        expected.add(new Address("Moscow", "Chertanovskaya", 1, 12));
        assertThat(rsl, is(expected));
    }

    @Test
    public void profileTestDuplic() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Tverskaya", 10, 1)),
                new Profile(new Address("Anapa", "Chertanovskaya", 1, 12)),
                new Profile(new Address("Anapa", "Chertanovskaya", 1, 12))
        );
        List<Address> rsl = Profiles.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Anapa", "Chertanovskaya", 1, 12));
        expected.add(new Address("Moscow", "Tverskaya", 10, 1));
        assertThat(rsl, is(expected));
    }
}