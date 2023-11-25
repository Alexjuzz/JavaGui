package org.example;
/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
 sum(), multiply(), divide(), subtract(). Параметры этих методов
 – два числа разного типа, над которыми должна быть произведена операция.
Напишите обобщенный метод compareArrays(), который принимает два массива
 и возвращает true, если они одинаковые, и false в противном случае. Массивы
 могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
Напишите обобщенный класс Pair, который представляет собой пару значений
 разного типа. Класс должен иметь методы getFirst(), getSecond() для получения
 значений каждого из составляющих пары, а также переопределение метода toString(), возвращающее строковое представление пары.
 */
public class  Calcs {


    public static <T extends  Number> T sum(T num1,T num2){
        return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
    }
    public static <T extends  Number> T mult(T num1,T num2){
        return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
    }
    public static <T extends  Number> T division(T num1,T num2){
        if(num2.doubleValue() > 0) return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
        else return (T) Double.valueOf(0);
    }
    public static <T extends  Number> T sub(T num1,T num2){
        return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
    }
}
