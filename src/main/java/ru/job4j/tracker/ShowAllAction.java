package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] arr = tracker.findAll();
        for(Item item: arr) {
            System.out.println(item);
        }
        return true;
    }
}
