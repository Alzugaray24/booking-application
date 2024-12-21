package com.booking.Models.alojamiento;

import java.util.Date;
import java.util.List;

import com.booking.Models.habitacion.Habitacion;
import com.booking.Models.reserva.ReservaData;

public class Finca extends Alojamiento {

    public Finca() {

    }

    public Finca(String nombre, String ciudad, TipoAlojamiento tipo, Float precioBase, List<Habitacion> habitaciones, Float calificacion, Date fechaInicio, Date fechaFin) {
        super(nombre, ciudad, tipo, precioBase, habitaciones, calificacion, fechaInicio, fechaFin);
    }

    @Override
    public void decorarHabiracion() {
        System.out.println("Decorando habitación de finca");
    }


}