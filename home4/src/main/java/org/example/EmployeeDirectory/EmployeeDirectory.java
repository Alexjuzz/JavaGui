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
    private    List<Person> personList;

    public EmployeeDirectory() {
        this.personList = new ArrayList<>();
    }

    public List<String> getPhoneByName(String name) {
        List<String> resultList = new ArrayList<>();
        for (Person p : personList) {
            if(p.getName().equals(name)){
                resultList.add("Номер сотрудника " + p.getName() + " " + p.getPhone());
            }
        }
        return resultList;
    }
    public String getPersonById(int id) {
        for (Person p : personList) {
            if(p.getId() == id){
                return p.getName();
            }
        }return "Сотрудник не найден";
    }
    public List<Person> getPersonByExperience(double experience){
        List<Person> people = new ArrayList<>();
        for (Person p : personList) {
            if(p.getExperience() == experience){
                people.add(p);
            }
        }
        return people;
    }

    public boolean addPerson(Person person) {
        if (person == null) {
            return false;
        }
        if (personList.size() == 0) {
            personList.add(person);
        } else {
           if(!checkPersonOnList(person)){
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
            return !(p.getId() == person.getId());
        }

        return  false;
    }
    public void getSize(){
        System.out.println(personList.size());
    }
}
