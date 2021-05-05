package ru.job4j.oop;

public class Dentist extends Doctor {
    private int toothDeleted;

    public Dentist(String name, String surname, String education,
                   String birthday, int toothDeleted) {
        super(name, surname, education, birthday);
        this.toothDeleted = toothDeleted;
    }

    public int getToothDeleted() {
        return toothDeleted;
    }

    public void deleteTooth() {

    }
}
