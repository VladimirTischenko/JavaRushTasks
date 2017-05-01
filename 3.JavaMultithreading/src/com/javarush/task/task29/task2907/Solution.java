package com.javarush.task.task29.task2907;

import java.math.BigDecimal;
import java.math.MathContext;

/* 
Этот странный BigDecimal
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        String s1 = String.valueOf(v1);
        String s2 = String.valueOf(v2);
        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);
        return bigDecimal1.add(bigDecimal2);
    }
}