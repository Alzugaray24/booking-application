package com.booking.utils;

import com.booking.Models.alojamiento.Alojamiento;
import com.booking.Models.alojamiento.TipoAlojamiento;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BuscarAlojamientoUtils {

    public static List<Alojamiento> buscarAlojamientos(List<Alojamiento> alojamientos, String nombre, String ciudad, TipoAlojamiento tipoAlojamiento, Date fechaInicio, Date fechaFin, int cantidadAdultos, int cantidadNinos) {
        return alojamientos.stream()
                .filter(alojamiento -> alojamiento.getNombre().equalsIgnoreCase(nombre))
                .filter(alojamiento -> alojamiento.getCiudad().equalsIgnoreCase(ciudad))
                .filter(alojamiento -> alojamiento.getTipo().equals(tipoAlojamiento))
                .filter(alojamiento -> alojamiento.getFechaInicio().compareTo(fechaInicio) <= 0 && alojamiento.getFechaFin().compareTo(fechaFin) >= 0)
                .filter(alojamiento -> tieneHabitacionesAdecuadas(alojamiento, cantidadAdultos, cantidadNinos))
                .collect(Collectors.toList());
    }

    private static boolean tieneHabitacionesAdecuadas(Alojamiento alojamiento, int cantidadAdultos, int cantidadNinos) {
        long habitacionesAdecuadas = alojamiento.getHabitaciones().stream()
                .filter(habitacion -> habitacion.getCantidadAdultos() >= cantidadAdultos && habitacion.getCantidadMenores() >= cantidadNinos)
                .count();

        return habitacionesAdecuadas > 0;
    }

    public static double calcularPrecioTotal(Alojamiento alojamiento, Date fechaInicio, Date fechaFin, int cantidadHabitaciones) {
        double precioBase = alojamiento.getHabitaciones().stream()
                .mapToDouble(habitacion -> habitacion.getPrecio())
                .min()
                .orElse(0.0);

        double precioTotal = precioBase * cantidadHabitaciones;
        double aumentoDescuento = 0.0;

        if (esUltimosCincoDiasDelMes(fechaInicio, fechaFin)) {
            aumentoDescuento = precioTotal * 0.15;
            precioTotal += aumentoDescuento;
        } else if (esDiasDel10Al15(fechaInicio, fechaFin)) {
            aumentoDescuento = precioTotal * 0.10;
            precioTotal += aumentoDescuento;
        } else if (esDiasDel5Al10(fechaInicio, fechaFin)) {
            aumentoDescuento = precioTotal * 0.08;
            precioTotal -= aumentoDescuento;
        }

        System.out.println("Aumento/Descuento aplicado: " + aumentoDescuento);
        return precioTotal;
    }

    private static boolean esUltimosCincoDiasDelMes(Date fechaInicio, Date fechaFin) {
        return false;
    }

    private static boolean esDiasDel10Al15(Date fechaInicio, Date fechaFin) {
        return false;
    }

    private static boolean esDiasDel5Al10(Date fechaInicio, Date fechaFin) {
        return false;
    }

    public static List<Alojamiento> buscarAlojamientosDiaDeSol(List<Alojamiento> alojamientos) {
        return alojamientos.stream()
                .filter(alojamiento -> alojamiento.getTipo().equals(TipoAlojamiento.DIADESOL))
                .collect(Collectors.toList());
    }
}