package org.example;

import org.example.second.Animals;
import org.example.second.Cat;
import org.example.second.CompareArraysClass;
import org.example.second.Dog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       Calcs calc = new Calcs();
       CompareArraysClass compareArraysClass = new CompareArraysClass();
        List<Cat> cats1 = List.of(new Cat(), new Cat(), new Cat());
        List<Cat> cats2 = List.of(new Cat(), new Cat(), new Cat());



        List<Dog> dogs = List.of(new Dog(), new Dog(), new Dog());
        List<Animals> animals = List.of(new Dog(), new Dog(), new Cat());

        System.out.println("Compare cats1 and cats2: " + compareArraysClass.CompareArray(cats1, cats1));
        System.out.println("Compare cats1 and dogs: " + compareArraysClass.CompareArray(cats1, dogs));
        System.out.println("Compare cats1 and Animals: " + compareArraysClass.CompareArray(cats1, animals));
    }
    }
