package org.example.EmployeeDirectory.Persons;

public class HRPerson implements Person {
    private String name;
    private int age;
    private int id;
    private int experience;

    public HRPerson(String name, int age, int id, int experience) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.experience = experience;
    }

    @Override
    public int getExperience() {
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
}
