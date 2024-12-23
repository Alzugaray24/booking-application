package com.booking.Models.reserva;

import com.booking.Models.alojamiento.Alojamiento;

import java.util.Date;
import java.util.List;

public interface IReserva {

    public void crearReserva(List<ReservaImplementacion> reservaData, Integer cantidadHabitaciones, Date horaDeLlegada);

    public void eliminarReserva();

    public void modificarReserva();

    public void consultarReserva();

}