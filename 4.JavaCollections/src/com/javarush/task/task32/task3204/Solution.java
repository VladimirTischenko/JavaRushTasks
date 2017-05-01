package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        boolean useDigit = false;
        boolean useLower = false;
        boolean useUpper = false;
        ByteArrayOutputStream byteArrayOutputStream = null;
        int[] ints = new int[0];
        Random random = new Random();

        while (!useDigit || !useLower || !useUpper) {
             byteArrayOutputStream = new ByteArrayOutputStream();
             ints = new int[8];

            for (int i = 0; i < 8; i++) {
                char symbol = 0;
                int range = 10;

                switch(random.nextInt(3)) {
                    case 0: {symbol = '0'; range = 10;} break;
                    case 1: {symbol = 'a'; range = 26;} break;
                    case 2: {symbol = 'A'; range = 26;} break;
                }

                ints[i] = (random.nextInt(range)) + symbol;
            }

            useDigit = useDigit(ints);
            useLower = useLower(ints);
            useUpper = useUpper(ints);
        }

        for (int i = 0; i < 8; i++) {
            byteArrayOutputStream.write(ints[i]);
        }

        return byteArrayOutputStream;
    }

    private static boolean useDigit(int[] ints) {
        for (int i = 0; i < 8; i++) {
            int j = ints[i];
            if (j >= 48 && j <= 57) {
                return true;
            }
        }
        return false;
    }

    private static boolean useLower(int[] ints) {
        for (int i = 0; i < 8; i++) {
            int j = ints[i];
            if (j >= 97 && j <= 122) {
                return true;
            }
        }
        return false;
    }

    private static boolean useUpper(int[] ints) {
        for (int i = 0; i < 8; i++) {
            int j = ints[i];
            if (j >= 65 && j <= 90) {
                return true;
            }
        }
        return false;
    }
}