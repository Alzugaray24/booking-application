package com.booking.utils;

import java.util.Scanner;

public class MenuUtils {

    public static int mostrarMenu(Scanner scanner) {
        System.out.println("\nMenú:");
        System.out.println("1. Buscar alojamiento");
        System.out.println("2. Confirmar habitación");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
}