package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete item ====");
        int itemId = input.askInt("Enter ID ");
        if (store.delete(itemId)) {
            out.println("Item deleted successfully");
        } else {
            out.println("Error: An item with this ID was not found.");
        }
        return true;
    }
}
