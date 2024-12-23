package com.booking.utils;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class ConsoleDateUtils {
    private final Scanner scanner = new Scanner(System.in);

    public String getDate(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public Date parseDate(String dateString, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateString);
    }

    public Date getDateAsObject(String message, String format) {
        String dateString = getDate(message);
        try {
            return parseDate(dateString, format);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Inténtalo de nuevo.");
            return null;
        }
    }
}