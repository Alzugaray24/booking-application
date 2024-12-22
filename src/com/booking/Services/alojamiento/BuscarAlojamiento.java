package com.booking.Services.alojamiento;

import com.booking.Models.alojamiento.Alojamiento;
import com.booking.Models.alojamiento.TipoAlojamiento;
import com.booking.Repositories.AlojamientoRespository;
import com.booking.Services.interfaces.ICommand;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BuscarAlojamiento implements ICommand<List<Alojamiento>> {

    private final AlojamientoRespository alojamientos;
    private final ConsoleStringUtils mensajeRecibido;
    private final ConsoleIntegerUtils numeroRecibido;
    private final ConsoleDateUtils fechaRecibida;

    public BuscarAlojamiento(AlojamientoRespository alojamientos, ConsoleStringUtils mensajeRecibido, ConsoleIntegerUtils numeroRecibido, ConsoleDateUtils fechaRecibida) {
        this.alojamientos = alojamientos;
        this.mensajeRecibido = mensajeRecibido;
        this.numeroRecibido = numeroRecibido;
        this.fechaRecibida = fechaRecibida;
    }

    @Override
    public List<Alojamiento> execute() {
        String nombre = mensajeRecibido.getString("Ingrese el nombre del alojamiento");
        String ciudad = mensajeRecibido.getString("Ingrese la ciudad");

        TipoAlojamiento tipoAlojamiento = TipoAlojamiento.valueOf(mensajeRecibido.getString("Ingrese el tipo de alojamiento (HOTEL, APARTAMENTO, FINCA, DIADESOL)").toUpperCase());


        Date fechaInicio = fechaRecibida.getDateAsObject("Ingrese la fecha de inicio del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");
        Date fechaFin = fechaRecibida.getDateAsObject("Ingrese la fecha de finalización del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");
        int cantidadAdultos = numeroRecibido.getInteger("Ingrese la cantidad de adultos");
        int cantidadNinos = numeroRecibido.getInteger("Ingrese la cantidad de niños");

        return buscarAlojamientos(nombre, ciudad, tipoAlojamiento, fechaInicio, fechaFin, cantidadAdultos, cantidadNinos);
    }

    private List<Alojamiento> buscarAlojamientos(String nombre, String ciudad, TipoAlojamiento tipoAlojamiento, Date fechaInicio, Date fechaFin, int cantidadAdultos, int cantidadNinos) {
        return alojamientos.getAlojamientos().stream()
                .filter(alojamiento -> alojamiento.getNombre().equalsIgnoreCase(nombre))
                .filter(alojamiento -> alojamiento.getCiudad().equalsIgnoreCase(ciudad))
                .filter(alojamiento -> alojamiento.getTipo().equals(tipoAlojamiento))
                .filter(alojamiento -> alojamiento.getFechaInicio().compareTo(fechaInicio) <= 0 && alojamiento.getFechaFin().compareTo(fechaFin) >= 0)
                .filter(alojamiento -> tieneHabitacionesAdecuadas(alojamiento, cantidadAdultos, cantidadNinos))
                .collect(Collectors.toList());
    }

    private boolean tieneHabitacionesAdecuadas(Alojamiento alojamiento, int cantidadAdultos, int cantidadNinos) {
        long habitacionesAdecuadas = alojamiento.getHabitaciones().stream()
                .filter(habitacion -> habitacion.getCantidadAdultos() >= cantidadAdultos && habitacion.getCantidadMenores() >= cantidadNinos)
                .count();

        return habitacionesAdecuadas > 0;
    }
}