package org.example.Third;
//Напишите обобщенный класс Pair, который представляет собой пару значений
//разного типа. Класс должен иметь методы getFirst(), getSecond() для получения
//значений каждого из составляющих пары, а также переопределение метода toString(), возвращающее строковое представление пары.
public class Pair <K,V> {
   private K key;
   private V value;
    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                 "Ключ :" + getFirst() + " Значение: "
                + getSecond() +
                '}';
    }

    public K getFirst() {
        return key;
    }

    public V getSecond() {
        return value;
    }
}
