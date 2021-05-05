package ru.job4j.oop;

public class Builder extends Engineer {
    private String companyName;

    public Builder(String name, String surname, String education,
                   String birthday, String companyName) {
        super(name, surname, education, birthday);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void buildHouse() {
    }
}
