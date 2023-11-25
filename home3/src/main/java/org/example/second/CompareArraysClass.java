package org.example.second;

import java.util.List;

/*
Напишите обобщенный метод compareArrays(), который принимает два массива
 и возвращает true, если они одинаковые, и false в противном случае. Массивы
 могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */
public class CompareArraysClass {

    public <T,V> boolean CompareArray(List<T> value, List<V> value2) {
        if(!(value.size() == value2.size())){
            return false;
        }
        /**
         * // бегу по листам и сравниваю навзвание класса
         * // первого элемента со всеми названиями классов этого же листа.
         * // Наверное можно было сисользовать InstanceOf
         */
        for (int i = 0; i < value.size(); i++) {
            if(!((value.get(0).getClass().getName().equals(value.get(i).getClass().getName()))
                    && (value2.get(0).getClass().getName().equals(value2.get(i).getClass().getName()))) ){
                return false;
            }

        }
        return true;
    }

}
