package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 25; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
        cache.put(5l, new AnyObject(30l, "asd", "zxc"));
    }
}