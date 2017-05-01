package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList();
        Stack<File> stack = new Stack();
        File rootDir = new File(root);
        stack.push(rootDir);
        while (!stack.isEmpty()) {
            File file = stack.pop();
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for(File f : files) {
                    stack.push(f);
                }
            } else {
                fileTree.add(file.toString());
            }
        }
        return fileTree;
    }

    public static void main(String[] args) throws IOException{
        List<String> fileTree = getFileTree("e:/test/");
        if (fileTree != null) {
            for(String s : fileTree) {
                System.out.println(s);
            }
        }
    }
}
