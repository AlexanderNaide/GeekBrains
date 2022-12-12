package ru.gb.spring_mvc.model;

public class Student {

    private static Long counter = 1L;
    private Long id;
    private String name;

    public Student() {
        this.id = counter++;
        this.name = "Student #" + id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
