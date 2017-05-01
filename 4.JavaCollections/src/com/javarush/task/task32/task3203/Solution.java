package com.javarush.task.task32.task3203;

import java.io.PrintWriter;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
//        StackTraceElement[] stackTraceElement = throwable.getStackTrace();
//        int lastStackTraceElementIndex = stackTraceElement.length - 1;
//        for (int i = 0; i < lastStackTraceElementIndex; i++) {
//            stringWriter.write(stackTraceElement[i].toString());
//            stringWriter.write("\n");
//        }
//        stringWriter.write(stackTraceElement[lastStackTraceElementIndex].toString());
//        return stringWriter.toString();

        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}