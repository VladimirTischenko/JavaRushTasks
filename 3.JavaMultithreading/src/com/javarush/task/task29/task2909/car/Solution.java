package com.javarush.task.task29.task2909.car;

import com.javarush.task.task29.task2909.human.Human;

import java.util.Date;
import java.util.List;

/**
 * Created by Vladimir on 29.04.2017.
 */
public class Solution {
    public static void main(String[] args) {
        Date date1 = new Date(2017, 05, 01);
        Date date2 = new Date(2017, 06, 01);
        Date date3 = new Date(2017, 07, 01);
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));
        System.out.println(date2.before(date1));
    }
}
