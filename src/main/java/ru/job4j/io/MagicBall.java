package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int answer = new Random().nextInt(3);
        String rsl;
        switch (answer) {
            case 0 : rsl = "Да";
            break;
            case 1 : rsl = "Нет";
            break;
            default: rsl = "Может быть";
        }
        System.out.println(rsl);
    }
}
