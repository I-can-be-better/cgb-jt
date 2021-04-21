package com.jt.factory;

import java.util.Calendar;

public class StaticFactory {
    public static Calendar getCalendars(){
        return Calendar.getInstance();
    }
}
