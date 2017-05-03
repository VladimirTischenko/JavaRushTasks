package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileReader fileReader = new FileReader(new File(fileName));
        return mapper.readValue(fileReader, clazz);
    }

    public static void main(String[] args) throws IOException {
        Human human = convertFromJsonToNormal("e:/test/fileName.txt", Human.class);
        System.out.println(human);
    }
}

@JsonAutoDetect
class Human {
    public String name;
    public int age, weight;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
