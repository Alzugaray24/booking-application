// src/com/booking/Services/alojamiento/ConfirmarHabitacion.java
package com.booking.Services.alojamiento;

import com.booking.Models.habitacion.Habitacion;
import com.booking.Models.alojamiento.Alojamiento;
import com.booking.Repositories.AlojamientoRespository;
import com.booking.Services.interfaces.ICommand;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ConfirmarHabitacion implements ICommand {

    private final AlojamientoRespository alojamientos;
    private final ConsoleStringUtils mensajeRecibido;
    private final ConsoleIntegerUtils numeroRecibido;
    private final ConsoleDateUtils fechaRecibida;

    public ConfirmarHabitacion(AlojamientoRespository alojamientos, ConsoleStringUtils mensajeRecibido, ConsoleIntegerUtils numeroRecibido, ConsoleDateUtils fechaRecibida) {
        this.alojamientos = alojamientos;
        this.mensajeRecibido = mensajeRecibido;
        this.numeroRecibido = numeroRecibido;
        this.fechaRecibida = fechaRecibida;
    }

    @Override
    public Object execute() {
        String nombreHotel = mensajeRecibido.getString("Ingrese el nombre del hotel: ");
        Date fechaInicio = fechaRecibida.getDateAsObject("Ingrese la fecha de inicializacion del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");
        Date fechaFin = fechaRecibida.getDateAsObject("Ingrese la fecha de finalización del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");
        int cantidadAdultos = numeroRecibido.getInteger("Ingrese la cantidad de adultos: ");
        int cantidadNinos = numeroRecibido.getInteger("Ingrese la cantidad de niños: ");
        int cantidadHabitaciones = numeroRecibido.getInteger("Ingrese la cantidad de habitaciones: ");

        return confirmarHabitaciones(nombreHotel, fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);
    }

    public List<Habitacion> confirmarHabitaciones(String nombreHotel, Date fechaInicio, Date fechaFin, int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {
        return alojamientos.getAlojamientos().stream()
                .filter(alojamiento -> esAlojamientoValido(alojamiento, nombreHotel, fechaInicio, fechaFin))
                .flatMap(alojamiento -> alojamiento.getHabitaciones().stream())
                .filter(habitacion -> esHabitacionValida(habitacion, cantidadAdultos, cantidadNinos))
                .limit(cantidadHabitaciones)
                .collect(Collectors.toList());
    }

    private boolean esAlojamientoValido(Alojamiento alojamiento, String nombreHotel, Date fechaInicio, Date fechaFin) {
        return alojamiento.getNombre().equalsIgnoreCase(nombreHotel) &&
                alojamiento.getFechaInicio().compareTo(fechaInicio) <= 0 &&
                alojamiento.getFechaFin().compareTo(fechaFin) >= 0;
    }

    private boolean esHabitacionValida(Habitacion habitacion, int cantidadAdultos, int cantidadNinos) {
        return habitacion.getDisponibilidad() &&
                habitacion.getCantidadAdultos() >= cantidadAdultos &&
                habitacion.getCantidadMenores() >= cantidadNinos;
    }
}