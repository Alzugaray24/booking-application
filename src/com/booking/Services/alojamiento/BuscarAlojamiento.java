package com.booking.Services.alojamiento;

import com.booking.Models.alojamiento.Alojamiento;
import com.booking.Models.alojamiento.TipoAlojamiento;
import com.booking.Repositories.AlojamientoRespository;
import com.booking.Services.interfaces.ICommand;
import com.booking.utils.BuscarAlojamientoUtils;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;

import java.util.Date;
import java.util.List;

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
        String nombre = obtenerNombre();
        String ciudad = obtenerCiudad();
        TipoAlojamiento tipoAlojamiento = obtenerTipoAlojamiento();
        Date fechaInicio = obtenerFechaInicio();
        Date fechaFin = obtenerFechaFin();
        int cantidadAdultos = obtenerCantidadAdultos();
        int cantidadNinos = obtenerCantidadNinos();

        List<Alojamiento> alojamientosEncontrados = BuscarAlojamientoUtils.buscarAlojamientos(
                alojamientos.getAlojamientos(), nombre, ciudad, tipoAlojamiento, fechaInicio, fechaFin, cantidadAdultos, cantidadNinos);

        if (tipoAlojamiento == TipoAlojamiento.DIADESOL) {
            alojamientosEncontrados = BuscarAlojamientoUtils.buscarAlojamientosDiaDeSol(alojamientos.getAlojamientos());
        }

        mostrarPreciosTotales(alojamientosEncontrados, fechaInicio, fechaFin);

        return alojamientosEncontrados;
    }

    private String obtenerNombre() {
        return mensajeRecibido.getString("Ingrese el nombre del alojamiento");
    }

    private String obtenerCiudad() {
        return mensajeRecibido.getString("Ingrese la ciudad");
    }

    private TipoAlojamiento obtenerTipoAlojamiento() {
        return TipoAlojamiento.valueOf(mensajeRecibido.getString("Ingrese el tipo de alojamiento (HOTEL, APARTAMENTO, FINCA, DIA_DE_SOL)").toUpperCase());
    }

    private Date obtenerFechaInicio() {
        return fechaRecibida.getDateAsObject("Ingrese la fecha de inicio del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");
    }

    private Date obtenerFechaFin() {
        return fechaRecibida.getDateAsObject("Ingrese la fecha de finalización del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");
    }

    private int obtenerCantidadAdultos() {
        return numeroRecibido.getInteger("Ingrese la cantidad de adultos");
    }

    private int obtenerCantidadNinos() {
        return numeroRecibido.getInteger("Ingrese la cantidad de niños");
    }

    private void mostrarPreciosTotales(List<Alojamiento> alojamientosEncontrados, Date fechaInicio, Date fechaFin) {
        for (Alojamiento alojamiento : alojamientosEncontrados) {
            double precioTotal = BuscarAlojamientoUtils.calcularPrecioTotal(alojamiento, fechaInicio, fechaFin, 1);
            System.out.println("Precio total: " + precioTotal);
        }
    }
}