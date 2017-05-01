package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        ArrayList<Integer> list = new ArrayList();
        int number = 0;
        while (true) {
            s = bufferedReader.readLine();
            number = Integer.parseInt(s);
            if (number == -1) {
                break;
            } else {
                list.add(number);
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum / (list.size() * 1.0));
    }
}

