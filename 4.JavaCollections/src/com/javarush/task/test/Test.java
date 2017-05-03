package com.javarush.task.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;

/**
 * Created by Vladimir on 13.03.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        House house = new House();
        house.pets.add(dog);
        house.pets.add(cat);

        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, house);
        System.out.println(writer.toString());
    }
}