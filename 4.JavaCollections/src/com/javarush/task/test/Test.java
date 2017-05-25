package com.javarush.task.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vladimir on 13.03.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        Calendar calendar = Calendar.getInstance();
//        Date time = calendar.getTime();
//        System.out.println(time);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
//        System.out.println(dateFormat.format(time));
//        String[] strings = "asd".split(":");
//        System.out.println(strings.length);
//        System.out.println(strings[0]);
//        System.out.println(strings[1]);

        String[] strings = "Боб:го".split(":");
        if (strings.length > 1) {
            String stringDateFormat = "";
            switch (strings[1]) {
                case "дата":
                    stringDateFormat = "d.MM.YYYY";
                    break;
                case "день":
                    stringDateFormat = "d";
                    break;
                case "месяц":
                    stringDateFormat = "MMMM";
                    break;
                case "год":
                    stringDateFormat = "YYYY";
                    break;
                case "время":
                    stringDateFormat = "H:mm:ss";
                    break;
                case "час":
                    stringDateFormat = "H";
                    break;
                case "минуты":
                    stringDateFormat = "m";
                    break;
                case "секунды":
                    stringDateFormat = "s";
                    break;
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
            Calendar calendar = Calendar.getInstance();
            Date time = calendar.getTime();
            System.out.println(time);
            System.out.println("Информация для " + strings[0] + ": " + dateFormat.format(time));
        }
    }
}