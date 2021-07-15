package ru.job4j.tracker;

public class FindIDAction implements UserAction {
    private final Output out;

    public FindIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find item by Id ===");
        int itemId = input.askInt("Enter ID ");
        Item item = store.findById(itemId);
        if (item != null) {
            out.println(item);
        } else {
            out.println("The item with this id was not found");
        }
        return true;
    }
}
