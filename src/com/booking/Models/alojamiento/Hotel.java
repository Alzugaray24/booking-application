package com.booking.Models.alojamiento;

import java.util.Date;
import java.util.List;

import com.booking.Models.habitacion.Habitacion;
import com.booking.Models.reserva.ReservaData;

public class Hotel extends Alojamiento {

    public Hotel () {

    }

    public Hotel(String nombre, String ciudad, TipoAlojamiento tipo, Float precioBase, List<Habitacion> habitaciones, Float calificacion, Date fechaInicio, Date fechaFin) {
        super(nombre, ciudad, tipo, precioBase, habitaciones, calificacion, fechaInicio, fechaFin);
    }

    @Override
    public void decorarHabiracion() {
        System.out.println("Decorando habitación de hotel");
    }

}