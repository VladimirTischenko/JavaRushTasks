package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] ints = new int[15];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ints.length; i++) {
            String line = reader.readLine();
            ints[i] = Integer.parseInt(line);
        }

        int even = 0, odd = 0;

        for (int i = 0; i < ints.length; i++) {
            if (i % 2 == 0) {
                even += ints[i];
            } else {
                odd += ints[i];
            }
        }

        if (odd > even) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        } else if (odd < even) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
    }
}
