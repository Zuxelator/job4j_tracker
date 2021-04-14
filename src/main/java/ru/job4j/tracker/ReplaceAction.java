package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int itemId = input.askInt("Enter ID ");
        String name = input.askStr("Enter name of new Item ");
        Item item = new Item(name);
        if(tracker.replace(itemId,item)) {
            System.out.println("Item changed successfully");
        } else {
            System.out.println("Error: An element with this ID was not found.");
        }
        return true;
    }
}
