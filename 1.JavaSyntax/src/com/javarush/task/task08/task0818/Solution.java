package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("qwe", 400);
        map.put("asd", 500);
        map.put("zxc", 600);
        map.put("rty", 400);
        map.put("fgh", 500);
        map.put("vbn", 600);
        map.put("qweqwe", 400);
        map.put("asdasd", 500);
        map.put("zxczxc", 600);
        map.put("qweasdzxc", 400);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() < 500) {
                list.add((String) entry.getKey());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            map.remove(list.get(i));
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
    }
}