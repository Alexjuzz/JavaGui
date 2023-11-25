package org.example;

import org.example.Third.Pair;
import org.example.second.Animals;
import org.example.second.Cat;
import org.example.second.CompareArraysClass;
import org.example.second.Dog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       Calcs calc = new Calcs();
       CompareArraysClass compareArraysClass = new CompareArraysClass();
        Pair<Integer,String> pair = new Pair<>(12,"VASYA");
        Pair<Float,Double> pair1 = new Pair<>(231f,0.0);


        List<Cat> cats1 = List.of(new Cat(), new Cat(), new Cat());
        List<Cat> cats2 = List.of(new Cat(), new Cat(), new Cat());
        List<Dog> dogs = List.of(new Dog(), new Dog(), new Dog());
        List<Animals> animals = List.of(new Dog(), new Dog(), new Cat());




        System.out.println("Compare cats1 and cats2: " + compareArraysClass.CompareArray(cats1, cats2));
        System.out.println("Compare cats1 and dogs: " + compareArraysClass.CompareArray(cats1, dogs));
        System.out.println("Compare cats1 and Animals: " + compareArraysClass.CompareArray(cats1, animals));

        System.out.println(pair);
        System.out.println(pair1);

        System.out.println(calc.sum(231,32f));
        System.out.println(calc.mult(1231,2.2));
        System.out.println(calc.division(100,10));
        System.out.println(calc.sub(300,0.1f));


    }
    }
