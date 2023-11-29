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

    }

    public boolean addPerson(Person person) {
        if (person == null) {
            return false;
        }
        if (personList.size() == 0) {
            personList.add(person);
        } else {
            for (Person p : personList
            ) {
                if (p.equals(person)) {
                    return false;
                } else {
                    personList.add(person);
                    return true;
                }
            }
        }
        return false;
    }
}
