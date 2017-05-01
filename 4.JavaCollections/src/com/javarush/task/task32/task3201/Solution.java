package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
            long point = Integer.parseInt(args[1]);
            long length = randomAccessFile.length();
            if (length < point) {
                point = length;
            }
            randomAccessFile.seek(point);
            randomAccessFile.write(args[2].getBytes());
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
