package com.javarush.task.test;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Vladimir on 13.05.2017.
 */
@XmlType(name = "zoo")
@XmlRootElement
public class Zoo
{
    @XmlAnyElement
    public List<Object> animals;

    @Override
    public String toString() {
        return "Zoo{" +
                "animals=" + animals +
                '}';
    }
}

