package com.javarush.task.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by Vladimir on 13.03.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String xmldata = "<zoo><cat/><cat/><dog/><cat/></zoo>";
        StringReader reader = new StringReader(xmldata);

        JAXBContext context = JAXBContext.newInstance(Cat.class, Zoo.class, Dog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Zoo zoo = (Zoo) unmarshaller.unmarshal(reader);
        System.out.println(zoo);
    }
}