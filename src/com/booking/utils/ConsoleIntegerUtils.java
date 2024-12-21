package com.booking.utils;

import java.util.Scanner;

public class ConsoleIntegerUtils {
    private final Scanner scanner = new Scanner(System.in);

    public Integer getInteger(String message) {
        System.out.println(message);
        int value;

        do {
            value = readInteger();
        } while (!isValid(value));

        return value;
    }

    public Double getDouble(String message) {
        System.out.println(message);
        double value;

        do {
            value = readDouble();
        } while (!isValid(value));

        return value;
    }

    public Float getFloat(String message) {
        System.out.println(message);
        float value;

        do {
            value = readFloat();
        } while (!isValid(value));

        return value;
    }

    private int readInteger() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ingresa un número con formato válido.");
            scanner.next();
            return -1;
        }
    }

    private double readDouble() {
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Ingresa un número con formato válido.");
            scanner.next();
            return -1;
        }
    }

    private float readFloat() {
        try {
            return scanner.nextFloat();
        } catch (Exception e) {
            System.out.println("Ingresa un número con formato válido.");
            scanner.next();
            return -1;
        }
    }

    private boolean isValid(int value) {
        boolean isValid = value >= 0;
        if (!isValid) {
            System.out.println("Ingresa un número positivo.");
        }
        return isValid;
    }

    private boolean isValid(double value) {
        boolean isValid = value >= 0;
        if (!isValid) {
            System.out.println("Ingresa un número positivo.");
        }
        return isValid;
    }

    private boolean isValid(float value) {
        boolean isValid = value >= 0;
        if (!isValid) {
            System.out.println("Ingresa un número positivo.");
        }
        return isValid;
    }
}