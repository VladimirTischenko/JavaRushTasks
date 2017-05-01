package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int p1 = number / 100;
        int p2 = number % 100 / 10;
        int p3 = number % 10;
        return p1 + p2 + p3;
    }
}