package com.booking.utils;

import com.booking.Models.habitacion.Habitacion;
import com.booking.Models.alojamiento.Alojamiento;

import java.util.Arrays;
import java.util.List;

public class HabitacionUtils {

    public static List<Habitacion> crearHabitaciones(String hotelNombre) {
        return Arrays.asList(
                new Habitacion(Arrays.asList("Individual", "Vista al mar"), 80.0, hotelNombre + " - Habitación 1", true, 1, 1, 80.0),
                new Habitacion(Arrays.asList("Doble", "Con baño privado"), 120.0, hotelNombre + " - Habitación 2", true, 1, 2, 120.0),
                new Habitacion(Arrays.asList("Triple", "Con terraza"), 150.0, hotelNombre + " - Habitación 3", true, 1, 3, 150.0),
                new Habitacion(Arrays.asList("Suite", "Con jacuzzi"), 250.0, hotelNombre + " - Habitación 4", true, 1, 2, 250.0),
                new Habitacion(Arrays.asList("Presidencial", "Con sala de estar"), 500.0, hotelNombre + " - Habitación 5", false, 1, 2, 500.0)
        );
    }

    public static void mostrarHabitaciones(Alojamiento alojamiento) {
        System.out.println("Habitaciones:");
        for (Habitacion habitacion : alojamiento.getHabitaciones()) {
            mostrarDetallesHabitacion(habitacion);
        }
    }

    public static void mostrarDetallesHabitacion(Habitacion habitacion) {
        System.out.println("  - " + habitacion.getDescripcion() + " | Precio: " + habitacion.getPrecio() + " | Disponibilidad: " + (habitacion.getDisponibilidad() ? "Disponible" : "No Disponible"));
        System.out.println("    Tipo de Habitación: " + habitacion.getTipoDeHabitacion());
        System.out.println("    Cantidad de Menores: " + habitacion.getCantidadMenores());
        System.out.println("    Cantidad de Adultos: " + habitacion.getCantidadAdultos());
        System.out.println("    Precio Base: " + habitacion.getPrecioBase());
    }
}