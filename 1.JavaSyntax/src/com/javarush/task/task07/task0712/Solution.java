package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextLine());
        }
        int min = Integer.MAX_VALUE, max = 0, minPos = 0, maxPos = 0;
        for (int i = 0; i < list.size(); i++) {
            int length = list.get(i).length();
            if (length < min) {
                min = length;
                minPos = i;
            }
            if (length > max) {
                max = length;
                maxPos = i;
            }
        }
        System.out.println(list.get(minPos < maxPos ? minPos : maxPos));
    }
}
