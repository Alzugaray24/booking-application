package com.booking.Services.reserva;

import com.booking.Models.reserva.ReservaImplementacion;
import com.booking.Repositories.ReservaRepository;
import com.booking.Services.interfaces.ICommand;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MostrarReservas implements ICommand<List<ReservaImplementacion>> {

    private final ReservaRepository reservaRepository;
    private final ConsoleStringUtils mensajeRecibido;

    public MostrarReservas(ReservaRepository reservaRepository, ConsoleStringUtils mensajeRecibido, ConsoleIntegerUtils numeroRecibido, ConsoleDateUtils fechaRecibida) {
        this.reservaRepository = reservaRepository;
        this.mensajeRecibido = mensajeRecibido;
    }

    @Override
    public List<ReservaImplementacion> execute() {
        String nombre = mensajeRecibido.getString("Ingrese el nombre del cliente:");
        String correo = mensajeRecibido.getString("Ingrese el correo del cliente:");

        List<ReservaImplementacion> reservasFiltradas = reservaRepository.getReservas().stream()
                .filter(reserva -> reserva.getCliente().getNombre().equalsIgnoreCase(nombre) &&
                        reserva.getCliente().getCorreo().equalsIgnoreCase(correo))
                .collect(Collectors.toList());

        reservasFiltradas.forEach(ReservaImplementacion::mostrarReserva);

        return reservasFiltradas;
    }
}