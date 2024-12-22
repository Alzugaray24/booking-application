package com.booking.utils;

import java.util.Scanner;

public class ConsoleStringUtils {

    private final Scanner scanner = new Scanner(System.in);

    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}