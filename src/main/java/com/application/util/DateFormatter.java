package com.application.util;

import java.text.SimpleDateFormat;

// Singleton class to restrict to single object of the class
public class DateFormatter extends SimpleDateFormat {
    private static final String FORMATTER = "mm/dd/yyyy";
    private static DateFormatter instance = null;

    private DateFormatter(){
        super(FORMATTER);
    }

    /**
     *
     * @return
     */
    public synchronized static DateFormatter getDateFormatter(){
        if(instance == null){
            instance = new DateFormatter();
        }
        return instance;
    }

}
