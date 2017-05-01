package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Path path = Paths.get(s);
        SearchFileVisitor visitor = new SearchFileVisitor();
        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, visitor);
            System.out.println("Всего папок - " + SearchFileVisitor.getDirCount());
            System.out.println("Всего файлов - " + SearchFileVisitor.getFilesCount());
            System.out.println("Общий размер - " + SearchFileVisitor.getDirSize());
        } else {
            System.out.println(path + " - не папка");
        }
    }
}
