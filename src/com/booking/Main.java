package com.booking;

import com.booking.Models.alojamiento.Alojamiento;
import com.booking.Repositories.AlojamientoRespository;
import com.booking.Services.alojamiento.BuscarAlojamiento;
import com.booking.utils.AlojamientoUtils;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;
import com.booking.utils.MenuUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlojamientoRespository alojamientoRespository = AlojamientoRespository.getInstance();

        AlojamientoUtils.agregarAlojamientos(alojamientoRespository);

        int seleccion;

        do {
            seleccion = MenuUtils.mostrarMenu(scanner);

            switch (seleccion) {
                case 1 -> {
                    System.out.println("Buscando alojamiento...");
                    buscarYMostrarAlojamientos(alojamientoRespository);
                }
                case 2 -> {
                    confirmarHabitaciones();
                }
                case 3 -> {
                    System.out.println("¡Hasta luego!");
                }
                default -> {
                    System.out.println("Selección inválida. Inténtelo nuevamente.");
                }
            }
        } while (seleccion != 3);

        scanner.close();
    }

    private static void buscarYMostrarAlojamientos(AlojamientoRespository alojamientoRespository) {
        ConsoleStringUtils mensajeRecibido = new ConsoleStringUtils();
        ConsoleIntegerUtils numeroRecibido = new ConsoleIntegerUtils();
        ConsoleDateUtils fechaRecibida = new ConsoleDateUtils();

        BuscarAlojamiento buscarAlojamiento = new BuscarAlojamiento(
                alojamientoRespository, mensajeRecibido, numeroRecibido, fechaRecibida);

        try {
            List<Alojamiento> alojamientosEncontrados = buscarAlojamiento.execute();
            System.out.println("Alojamientos encontrados:");
            AlojamientoUtils.mostrarAlojamientos(alojamientosEncontrados);
        } catch (Exception e) {
            System.err.println("Ocurrió un error al buscar los alojamientos: " + e.getMessage());
        }
    }

    private static void confirmarHabitaciones() {
        System.out.println("Confirmando habitación... (Por ahora solo se imprimirá un mensaje)");
    }
}