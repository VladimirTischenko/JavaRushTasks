package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
            randomAccessFile.seek(Long.parseLong(args[1]));
            String argText = args[2];
            int lengthText = argText.length();
            byte[] bytes = new byte[lengthText];
            randomAccessFile.read(bytes, 0, lengthText);
            String fileText = new String(bytes);
            String string;
            if (fileText.equals(argText)) {
                string = "true";
            } else {
                string = "false";
            }
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(string.getBytes());
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
