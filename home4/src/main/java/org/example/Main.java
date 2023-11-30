package org.example;

import org.example.EmployeeDirectory.EmployeeDirectory;
import org.example.EmployeeDirectory.Persons.HRPerson;
import org.example.EmployeeDirectory.Persons.Person;

/**
 * Сделаю дз в среду, не успеваю к сожалению сдавать во время, спасибо за понимание.
 */


public class Main {
    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        Person p = new HRPerson("Vasiliy",19,1,2.5,"841282");
        Person p7 = new HRPerson("Vasiliy",19,1,2.5,"842231");
        Person p2 = new HRPerson("Ivan",24,2,0.5,"4125511");
        Person p3 = new HRPerson("Petr",51,3,1.5,"391912");
        Person p4 = new HRPerson("Evgen",31,4,1.5,"812511");
        Person p5 = new HRPerson("Petr",22,5,5.5,"112351");
        Person p6 = new HRPerson("Vasiliy",39,6,2.5,"581822");
        employeeDirectory.addPerson(p);
        employeeDirectory.addPerson(p2);
        employeeDirectory.addPerson(p3);
        employeeDirectory.addPerson(p4);
        employeeDirectory.addPerson(p5);
        employeeDirectory.addPerson(p6);
        System.out.println(employeeDirectory.getPersonById(1));
        System.out.println(employeeDirectory.getPersonByExperience(1.5));
        System.out.println(employeeDirectory.getPhoneByName("Petr"));
    }
}