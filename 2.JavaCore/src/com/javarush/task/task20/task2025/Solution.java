package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static int[] getNumbers(long N) {
        int[] result = null;
        List<Integer> list = new ArrayList<>();
        for (int n = 1; n < N; n++) {
            int sum = 0, temp, r;
            int q = 0;
            temp = n;
            int length = (int) (Math.log10(n) + 1);
            while (temp != 0) {
                for (int i = 0; i < length; i++) {
                    int prod = 1;
                    r = temp % 10;
                    for (int j = 0; j < length; j++) {
                        prod = prod * r;
                    }
                    sum = sum + prod;
                    temp = temp / 10;
                }
            }
            if (n == sum) {
                list.add(n);
            }
        }
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    public static void main(String args[]) {
        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();
        int[] result = getNumbers(10000000);
        long memoryEnd = Runtime.getRuntime().maxMemory();
        long memoTaken = memoryStart - memoryEnd;
        System.out.println(memoTaken);
        Long t1 = System.currentTimeMillis();
        System.out.println("Time need to create the arrray = " + (t1 - t0));
        System.out.println("Used Memory in JVM: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()));
    }
}
