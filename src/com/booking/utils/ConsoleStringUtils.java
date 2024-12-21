package com.booking.utils;

import java.util.Scanner;

public class ConsoleStringUtils {
    private final Scanner scanner = new Scanner(System.in);

    public String getString(String message) {
        System.out.println(message);
        return scanner.next();
    }
}