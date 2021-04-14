package ru.job4j.tracker;

public class FindNameAction implements UserAction{
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name of item ");
        Item[] arr = tracker.findByName(name);
        if(arr.length > 0) {
            for (Item item : arr) {
                System.out.println(item);
            }
        } else {
            System.out.println("Items with this name not found");
        }
        return true;
    }
}
