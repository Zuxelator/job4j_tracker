package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Иванов Пётр Сергеевич");
        student.setGroup("1401Б");
        student.setDateOfAdmission(LocalDate.of(2020, 9, 10));
        System.out.println("ФИО : "
                + student.getFio()
                + System.lineSeparator()
                + "Группа : "
                + student.getGroup()
                + System.lineSeparator()
                + "Дата поступления : "
                + student.getDateOfAdmission());
    }
}
