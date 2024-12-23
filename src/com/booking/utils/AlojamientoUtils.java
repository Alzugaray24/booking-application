package com.booking.utils;

import com.booking.Models.alojamiento.Alojamiento;
import com.booking.Models.alojamiento.Hotel;
import com.booking.Models.alojamiento.TipoAlojamiento;
import com.booking.Models.habitacion.Habitacion;
import com.booking.Repositories.AlojamientoRespository;

import java.util.Arrays;
import java.util.List;

public class AlojamientoUtils {

    public static void agregarAlojamientos(AlojamientoRespository alojamientoRespository) {
        List<Habitacion> habitacionesHotel1 = HabitacionUtils.crearHabitaciones("Hotel A");
        List<Habitacion> habitacionesHotel2 = HabitacionUtils.crearHabitaciones("Hotel B");
        List<Habitacion> habitacionesHotel3 = HabitacionUtils.crearHabitaciones("Hotel C");

        Alojamiento hotel1 = crearHotel("Hotel A", "Ciudad A", habitacionesHotel1, "2023-12-01", "2023-12-10", 100.0, 3);
        Alojamiento hotel2 = crearHotel("Hotel B", "Ciudad B", habitacionesHotel2, "2023-12-05", "2023-12-15", 150.0, 5);
        Alojamiento hotel3 = crearHotel("Hotel C", "Ciudad C", habitacionesHotel3, "2023-12-10", "2023-12-20", 200.0, 2);

        alojamientoRespository.addAlojamiento(hotel1);
        alojamientoRespository.addAlojamiento(hotel2);
        alojamientoRespository.addAlojamiento(hotel3);
    }

    public static Alojamiento crearHotel(String nombre, String ciudad, List<Habitacion> habitaciones, String fechaInicio, String fechaFin, Double precioBase, Integer calificacion) {
        return new Hotel(nombre, ciudad, TipoAlojamiento.HOTEL, precioBase, habitaciones, calificacion, FechaUtils.parseDate(fechaInicio), FechaUtils.parseDate(fechaFin));
    }

    public static void mostrarAlojamientos(List<Alojamiento> alojamientos) {
        for (Alojamiento alojamiento : alojamientos) {
            mostrarDetallesAlojamiento(alojamiento);
            HabitacionUtils.mostrarHabitaciones(alojamiento);
            System.out.println("-----------------------------------------------------");
        }
    }

    public static void mostrarDetallesAlojamiento(Alojamiento alojamiento) {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Hotel: ").append(alojamiento.getNombre()).append("\n")
                .append("Ciudad: ").append(alojamiento.getCiudad()).append("\n")
                .append("Tipo: ").append(alojamiento.getTipo()).append("\n")
                .append("Calificación: ").append(alojamiento.getCalificacion()).append("\n")
                .append("Precio Base: ").append(alojamiento.getPrecioBase()).append("\n")
                .append("Fecha de Inicio: ").append(alojamiento.getFechaInicio()).append("\n")
                .append("Fecha de Fin: ").append(alojamiento.getFechaFin()).append("\n");
        System.out.println(detalles.toString());
    }
}