// src/com/booking/Services/reserva/ActualizarReserva.java
package com.booking.Services.reserva;

import com.booking.Models.reserva.ReservaImplementacion;
import com.booking.Repositories.ReservaRepository;
import com.booking.Services.interfaces.ICommand;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleStringUtils;

import java.util.Date;
import java.util.Optional;

public class ActualizarReserva implements ICommand<String> {

    private final ReservaRepository reservaRepository;
    private final ConsoleStringUtils mensajeRecibido;
    private final ConsoleDateUtils fechaRecibida;

    public ActualizarReserva(ReservaRepository reservaRepository, ConsoleStringUtils mensajeRecibido, ConsoleDateUtils fechaRecibida) {
        this.reservaRepository = reservaRepository;
        this.mensajeRecibido = mensajeRecibido;
        this.fechaRecibida = fechaRecibida;
    }

    @Override
    public String execute() {
        try {
            String correo = mensajeRecibido.getString("Ingrese el correo del cliente:");
            Date fechaNacimiento = fechaRecibida.getDateAsObject("Ingrese la fecha de nacimiento del cliente (yyyy-MM-dd):", "yyyy-MM-dd");

            Optional<ReservaImplementacion> reservaOpt = reservaRepository.getReservas().stream()
                    .filter(reserva -> reserva.getCliente().getCorreo().equalsIgnoreCase(correo) &&
                            reserva.getCliente().getFechaDeNacimiento().equals(fechaNacimiento))
                    .findFirst();

            if (reservaOpt.isPresent()) {
                ReservaImplementacion reserva = reservaOpt.get();
                mostrarDetallesReserva(reserva);

                String opcion = mensajeRecibido.getString("¿Desea cambiar la habitación o el alojamiento? (habitacion/alojamiento):");
                if (opcion.equalsIgnoreCase("habitacion")) {

                } else if (opcion.equalsIgnoreCase("alojamiento")) {

                } else {
                    return "Opción no válida.";
                }

                return "La reserva ha sido actualizada con éxito.";
            } else {
                return "No se encontró una reserva con los datos proporcionados.";
            }
        } catch (Exception e) {
            return "Ocurrió un error al actualizar la reserva: " + e.getMessage();
        }
    }

    private void mostrarDetallesReserva(ReservaImplementacion reserva) {
        StringBuilder detalles = new StringBuilder();
        detalles.append("Detalles de la Reserva:\n")
                .append("Cliente: ").append(reserva.getCliente().getNombre()).append(" ").append(reserva.getCliente().getApellido()).append("\n")
                .append("Correo: ").append(reserva.getCliente().getCorreo()).append("\n")
                .append("Fecha de Nacimiento: ").append(reserva.getCliente().getFechaDeNacimiento()).append("\n")
                .append("Hora de Llegada: ").append(reserva.getHoraDeLlegada()).append("\n")
                .append("Número de Habitaciones: ").append(reserva.getCantidadHabitaciones()).append("\n");
        System.out.println(detalles.toString());
    }
}