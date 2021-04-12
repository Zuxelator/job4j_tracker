package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] arr = tracker.findAll();
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Enter ID");
                int itemId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter name of new Item");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                if(tracker.replace(itemId,item)) {
                    System.out.println("Item changed successfully");
                } else {
                    System.out.println("Error: An element with this ID was not found.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Enter ID");
                int itemId = Integer.parseInt(scanner.nextLine());
                if(tracker.delete(itemId)) {
                    System.out.println("Item deleted successfully");
                } else {
                    System.out.println("Error: An item with this ID was not found.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                System.out.println("Enter ID");
                int itemId = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(itemId);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("The item with this id was not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.println("Enter name of item");
                String name = scanner.nextLine();
                Item[] arr = tracker.findByName(name);
                if(arr.length > 0) {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                } else {
                    System.out.println("Items with this name not found");
                }
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
        System.out.print("Select: ");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}