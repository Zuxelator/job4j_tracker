package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int itemId = input.askInt("Enter ID ");
        if(tracker.delete(itemId)) {
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("Error: An item with this ID was not found.");
        }
        return true;
    }
}
