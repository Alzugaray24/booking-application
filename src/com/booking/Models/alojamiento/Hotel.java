package com.booking.Models.alojamiento;

import java.util.Date;
import java.util.List;

import com.booking.Models.habitacion.Habitacion;

public class Hotel extends Alojamiento {

    public Hotel () {

    }

    public Hotel(String nombre, String ciudad, TipoAlojamiento tipo, Double precioBase, List<Habitacion> habitaciones, Integer calificacion, Date fechaInicio, Date fechaFin) {
        super(nombre, ciudad, tipo, precioBase, habitaciones, calificacion, fechaInicio, fechaFin);
    }

    @Override
    public void decorarHabiracion() {
        System.out.println("Decorando habitación de hotel");
    }

}