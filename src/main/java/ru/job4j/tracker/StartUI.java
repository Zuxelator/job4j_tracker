package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void  showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] arr = tracker.findAll();
        for(Item item: arr) {
            System.out.println(item);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int itemId = input.askInt("Enter ID ");
        String name = input.askStr("Enter name of new Item ");
        Item item = new Item(name);
        if(tracker.replace(itemId,item)) {
            System.out.println("Item changed successfully");
        } else {
            System.out.println("Error: An element with this ID was not found.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int itemId = input.askInt("Enter ID ");
        if(tracker.delete(itemId)) {
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("Error: An item with this ID was not found.");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int itemId = input.askInt("Enter ID ");
        Item item = tracker.findById(itemId);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("The item with this id was not found");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new ShowAllAction(), new ReplaceAction(), new DeleteAction(), new FindIDAction(), new FindNameAction(), new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}