package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int surgeonCounter;

    public Surgeon(String name, String surname, String education,
                   String birthday, int surgeonCounter) {
        super(name, surname, education, birthday);
        this.surgeonCounter = surgeonCounter;
    }

    public int getSurgeonCounter() {
        return surgeonCounter;
    }

    public void makeSurgery() {
    }
}
