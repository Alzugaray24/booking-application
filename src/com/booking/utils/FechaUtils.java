package com.booking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtils {

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Error al parsear la fecha: " + date, e);
        }
    }
}