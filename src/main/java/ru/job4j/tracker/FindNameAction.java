package ru.job4j.tracker;

import java.util.List;

public class FindNameAction implements UserAction{
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String name = input.askStr("Enter name of item ");
        List<Item> arr = tracker.findByName(name);
        if(arr.size() > 0) {
            for (Item item : arr) {
                out.println(item);
            }
        } else {
            out.println("Items with this name not found");
        }
        return true;
    }
}
