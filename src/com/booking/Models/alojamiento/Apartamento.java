package com.booking.Models.alojamiento;

import com.booking.Models.habitacion.Habitacion;
import com.booking.Models.reserva.ReservaData;

import java.util.Date;
import java.util.List;

public class Apartamento extends Alojamiento {

    public Apartamento() {

    }

    public Apartamento(String nombre, String ciudad, TipoAlojamiento tipo, Double precioBase, List<Habitacion> habitaciones, Integer calificacion, Date fechaInicio, Date fechaFin) {
        super(nombre, ciudad, tipo, precioBase, habitaciones, calificacion, fechaInicio, fechaFin);
    }

    @Override
    public void decorarHabiracion() {
        System.out.println("Decorando habitación de apartamento");
    }


}