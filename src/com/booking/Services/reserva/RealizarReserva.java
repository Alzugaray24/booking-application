package com.booking.Services.reserva;

import com.booking.Models.reserva.Cliente;
import com.booking.Models.reserva.ReservaImplementacion;
import com.booking.Repositories.ReservaRepository;
import com.booking.Services.interfaces.ICommand;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;

import java.util.Date;

public class RealizarReserva implements ICommand<String> {

    private final ReservaRepository reservaRepository;
    private final ConsoleStringUtils mensajeRecibido;
    private final ConsoleIntegerUtils numeroRecibido;
    private final ConsoleDateUtils fechaRecibida;

    public RealizarReserva(ReservaRepository reservaRepository, ConsoleStringUtils mensajeRecibido, ConsoleIntegerUtils numeroRecibido, ConsoleDateUtils fechaRecibida) {
        this.reservaRepository = reservaRepository;
        this.mensajeRecibido = mensajeRecibido;
        this.numeroRecibido = numeroRecibido;
        this.fechaRecibida = fechaRecibida;
    }

    @Override
    public String execute() {
        try {
            String nombre = mensajeRecibido.getString("Ingrese el nombre del cliente:");
            String apellido = mensajeRecibido.getString("Ingrese el apellido del cliente:");
            String correo = mensajeRecibido.getString("Ingrese el correo del cliente:");
            String nacionalidad = mensajeRecibido.getString("Ingrese la nacionalidad del cliente:");
            String numeroDeTelefono = mensajeRecibido.getString("Ingrese el número de teléfono del cliente:");
            Date horaDeLlegada = fechaRecibida.getDateAsObject("Ingrese la hora aproximada de llegada (HH:mm):", "HH:mm");

            Cliente cliente = new Cliente(nombre, apellido, correo, numeroDeTelefono, nacionalidad, null);
            ReservaImplementacion reserva = new ReservaImplementacion(horaDeLlegada, 1, cliente);

            reservaRepository.addReserva(reserva);

            return "Se ha realizado la reserva con éxito.";
        } catch (Exception e) {
            return "Ocurrió un error al realizar la reserva: " + e.getMessage();
        }
    }
}