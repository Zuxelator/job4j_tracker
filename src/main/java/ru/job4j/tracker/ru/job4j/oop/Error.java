package ru.job4j.tracker.ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active: " + active);
        System.out.println("status: " + status);
        System.out.println("message: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 400, "Ы?");
        Error error2 = new Error(false, 300, "Ы!");
        Error error3 = new Error(true, 500, "ЫЫЫ");
        error.printInfo();
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
