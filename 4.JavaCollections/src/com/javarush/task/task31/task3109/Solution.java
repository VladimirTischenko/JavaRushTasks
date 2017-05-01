package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        if (fileName.endsWith("xml")) {
            return getPropertiesFromXml(fileName);
        }
        try {
            properties.load(new FileReader(fileName));
        } catch (IOException e) {
            return properties;
        }
        return properties;
    }

    private Properties getPropertiesFromXml(String fileName) {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream(fileName));
        } catch (IOException e) {
            return properties;
        }
        return properties;
    }
}
