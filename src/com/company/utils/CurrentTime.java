package com.company.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {

    public static String getCurrentTime() {
//        2021-07-12 21:50:40
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
//        System.out.println("Текущее время: " + dateFormat.format(date));
        return dateFormat.format(date);
    }
}
