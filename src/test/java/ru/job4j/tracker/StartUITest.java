package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.ex.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList(new String[]{"0", "Item name", "1"})
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                Arrays.asList(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"})
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                Arrays.asList(new String[]{"0", String.valueOf(item.getId()), "1"})
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                Arrays.asList(new String[]{"0", String.valueOf(item.getId()), "1"})
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator()
                + "0. Show all items"
                + System.lineSeparator()
                + "1. Exit Program"
                + System.lineSeparator()
                + "=== Show all items ===="
                + System.lineSeparator()
                + item
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. Show all items"
                + System.lineSeparator()
                + "1. Exit Program"
                + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item item2 = tracker.add(new Item("Bug"));
        Item item3 = tracker.add(new Item("Fix"));
        Input in = new StubInput(
                Arrays.asList(new String[]{"0", item.getName(), "1"})
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator()
                + "0. Find items by name"
                + System.lineSeparator()
                + "1. Exit Program"
                + System.lineSeparator()
                + "=== Find items by name ==="
                + System.lineSeparator()
                + item + System.lineSeparator()
                + item2 + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. Find items by name"
                + System.lineSeparator()
                + "1. Exit Program"
                + System.lineSeparator()));

    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item item2 = tracker.add(new Item("Bug"));
        Item item3 = tracker.add(new Item("Fix"));
        Input in = new StubInput(
                Arrays.asList(new String[]{"0", String.valueOf(item3.getId()), "1"})
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindIDAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu."
                + System.lineSeparator()
                + "0. Find item by Id"
                + System.lineSeparator()
                + "1. Exit Program"
                + System.lineSeparator()
                + "=== Find item by Id ==="
                + System.lineSeparator()
                + item3
                + System.lineSeparator()
                + "Menu."
                + System.lineSeparator()
                + "0. Find item by Id"
                + System.lineSeparator()
                + "1. Exit Program"
                + System.lineSeparator()));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                Arrays.asList(new String[]{/* Пункты меню: неверный, верный. */ "10", "0"})
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu."
                        + ln
                        + "0. Exit Program"
                        + ln
                        + "Wrong input, you can select: 0 .. 0"
                        + ln
                        + "Menu."
                        + ln
                        + "0. Exit Program"
                        + ln
                )
        );
    }
}