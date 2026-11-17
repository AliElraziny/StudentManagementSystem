package com.sms.model;

/**
 * Represents a single student and the rules for his status and grade level.
 */
public class Student {

    private final String nationalId;
    private String name;
    private int age;
    private double grade;

    public Student(String nationalId, String name, int age, double grade) {
        this.nationalId = nationalId;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
