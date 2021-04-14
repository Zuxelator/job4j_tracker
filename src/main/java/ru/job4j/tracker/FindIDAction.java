package ru.job4j.tracker;

public class FindIDAction implements UserAction{
    private final Output out;

    public FindIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ===");
        int itemId = input.askInt("Enter ID ");
        Item item = tracker.findById(itemId);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("The item with this id was not found");
        }
        return true;
    }
}
