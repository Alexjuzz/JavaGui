package org.example.EmployeeDirectory;

import org.example.EmployeeDirectory.Persons.Person;

import java.util.ArrayList;
import java.util.List;

/*
Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
 */
public class EmployeeDirectory {
    List<Person> personList;

    public EmployeeDirectory() {
        this.personList = new ArrayList<>();
    }

    public List<String> getPersonByName(String name) {
        List<String> resultList = new ArrayList<>();
        for (Person p : personList) {
            if(p.getName().equals(name)){
                resultList.add(p.getName());
            }
        }
        return
    }

    public boolean addPerson(Person person) {
        if (person == null) {
            return false;
        }
        if (personList.size() == 0) {
            personList.add(person);
        } else {
           if(checkPersonOnList(person)){
               return false;
           }else {
               personList.add(person);
               return true;
           }
        }
        return false;
    }

    private boolean checkPersonOnList(Person person){
        for (Person p : personList
             ) {
            return !p.equals(person);
        }

        return  false;
    }
}
