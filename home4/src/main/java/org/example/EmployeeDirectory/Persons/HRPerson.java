package org.example.EmployeeDirectory.Persons;

public class HRPerson implements Person {
    private final String name;
    private final int age;
    private final int id;
    private double experience;
    private String phone;

    public HRPerson(String name, int age, int id, double experience) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.experience = experience;
    }

    @Override
    public double getExperience() {
        return this.experience;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }
}
