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
        int itemId = Integer.parseInt(input.askStr("Enter ID "));
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
        int itemId = Integer.parseInt(input.askStr("Enter ID "));
        if(tracker.delete(itemId)) {
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("Error: An item with this ID was not found.");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int itemId = Integer.parseInt(input.askStr("Enter ID "));
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
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        } else {
            System.out.println("Items with this name not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
               deleteItem(input, tracker);
            } else if (select == 4) {
                findItemByID(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}