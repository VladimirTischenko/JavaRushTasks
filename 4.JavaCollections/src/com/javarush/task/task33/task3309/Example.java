package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Vladimir on 15.05.2017.
 */
@XmlRootElement
@XmlType(name = "")
public class Example {
    public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};
}
