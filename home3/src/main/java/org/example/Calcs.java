package org.example;
/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
 sum(), multiply(), divide(), subtract(). Параметры этих методов
 – два числа разного типа, над которыми должна быть произведена операция.
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
