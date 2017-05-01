package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.List;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        int space1Index = string.indexOf(' ');
        int space2Index = string.indexOf(' ', space1Index + 1);
        int space3Index = string.indexOf(' ', space2Index + 1);
        int space4Index = string.indexOf(' ', space3Index + 1);
        if (string == null || string.isEmpty()
                || space1Index == -1 || space2Index == -1 || space3Index == -1 || space4Index == -1) {
            throw new TooShortStringException();
        }

        String s[] = string.split(" ");
        return s[1] + " " + s[2] + " " + s[3] + " " +  s[4];
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
