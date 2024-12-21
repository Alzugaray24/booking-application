package com.booking.Services.alojamiento;

import com.booking.Models.alojamiento.Alojamiento;
import com.booking.Models.alojamiento.Hotel;
import com.booking.Models.alojamiento.TipoAlojamiento;
import com.booking.Models.habitacion.Habitacion;
import com.booking.Repositories.AlojamientoRespository;
import com.booking.Services.interfaces.ICommand;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgregarAlojamiento implements ICommand<Void> {

    private final AlojamientoRespository alojamientoRespository;
    private final ConsoleStringUtils mensajeRecibido;
    private final ConsoleIntegerUtils numeroRecibido;
    private final ConsoleDateUtils fechaRecibida;

    public AgregarAlojamiento(AlojamientoRespository alojamientoRespository, ConsoleStringUtils mensajeRecibido, ConsoleIntegerUtils numeroRecibido, ConsoleDateUtils fechaRecibida) {
        this.alojamientoRespository = alojamientoRespository;
        this.mensajeRecibido = mensajeRecibido;
        this.numeroRecibido = numeroRecibido;
        this.fechaRecibida = fechaRecibida;
    }

    @Override
    public Void execute() {
        try {
            // Recolectar datos del usuario
            String nombre = mensajeRecibido.getString("Ingrese el nombre del hotel");
            String ciudad = mensajeRecibido.getString("Ingrese la ciudad del hotel");
            TipoAlojamiento tipoAlojamiento = obtenerTipoAlojamiento();
            Float precioBase = numeroRecibido.getFloat("Ingrese el precio base del hotel");
            Float calificacion = numeroRecibido.getFloat("Ingrese la calificación del hotel");
            Date fechaInicio = fechaRecibida.getDateAsObject("Ingrese la fecha de inicio del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");
            Date fechaFin = fechaRecibida.getDateAsObject("Ingrese la fecha de finalización del hospedaje (yyyy-MM-dd)", "yyyy-MM-dd");

            List<Habitacion> habitaciones = new ArrayList<>();

            Alojamiento alojamiento = new Hotel(
                    nombre,
                    ciudad,
                    tipoAlojamiento,
                    precioBase,
                    habitaciones,
                    calificacion,
                    fechaInicio,
                    fechaFin
            );

            alojamientoRespository.addAlojamiento(alojamiento);

            System.out.println("El alojamiento ha sido registrado exitosamente.");
        } catch (Exception e) {
            System.err.println("Ocurrió un error al registrar el alojamiento: " + e.getMessage());
        }
        return null;
    }

    private TipoAlojamiento obtenerTipoAlojamiento() {
        System.out.println("Seleccione el tipo de alojamiento:");
        System.out.println("1. HOTEL");
        System.out.println("2. FINCA");
        System.out.println("3. APARTAMENTO");
        System.out.println("4. DIADESOL");

        int seleccion = numeroRecibido.getInteger("Ingrese el número correspondiente:");

        return switch (seleccion) {
            case 1 -> TipoAlojamiento.HOTEL;
            case 2 -> TipoAlojamiento.FINCA;
            case 3 -> TipoAlojamiento.APARTAMENTO;
            case 4 -> TipoAlojamiento.DIADESOL;
            default -> {
                System.out.println("Selección inválida. Inténtelo nuevamente.");
                yield obtenerTipoAlojamiento();
            }
        };
    }
}