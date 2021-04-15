package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
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
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
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
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. Show all items" + System.lineSeparator() +
                                            "1. Exit Program" + System.lineSeparator() +
                                            "=== Show all items ====" + System.lineSeparator() +
                                            item + System.lineSeparator() +
                                            "Menu." + System.lineSeparator() +
                                            "0. Show all items" + System.lineSeparator() +
                                            "1. Exit Program" + System.lineSeparator() ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item item2 = tracker.add(new Item("Bug"));
        Item item3 = tracker.add(new Item("Fix"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find items by name" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                "=== Find items by name ===" + System.lineSeparator() +
                item + System.lineSeparator() +
                item2 + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find items by name" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() ));

    }

    @Test
    public void whenFindByID() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Bug"));
        Item item2 = tracker.add(new Item("Bug"));
        Item item3 = tracker.add(new Item("Fix"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item3.getId()), "1"}
        );
        UserAction[] actions = {
                new FindIDAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Find item by Id" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() +
                "=== Find item by Id ===" + System.lineSeparator() +
                item3 + System.lineSeparator() +
                "Menu." + System.lineSeparator() +
                "0. Find item by Id" + System.lineSeparator() +
                "1. Exit Program" + System.lineSeparator() ));
    }
}