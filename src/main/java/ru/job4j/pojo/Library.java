package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book sherlockHolmes = new Book("Sherlock Holmes", 500);
        Book dracula = new Book("Dracula", 600);
        Book wonnieThePooh = new Book("Wonnie-the-Pooh", 200);
        Book cleanCode = new Book("Clean code", 464);
        Book[] books = new Book[4];
        books[0] = sherlockHolmes;
        books[1] = dracula;
        books[2] = wonnieThePooh;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPageCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPageCount());
        }
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPageCount());
            }
        }
    }
}
