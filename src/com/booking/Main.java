package com.booking;

import com.booking.Repositories.AlojamientoRespository;
import com.booking.Services.alojamiento.AgregarAlojamiento;
import com.booking.utils.ConsoleDateUtils;
import com.booking.utils.ConsoleIntegerUtils;
import com.booking.utils.ConsoleStringUtils;

public class Main {
    public static void main(String[] args) {
        AlojamientoRespository alojamientoRespository = AlojamientoRespository.getInstance();
        ConsoleStringUtils mensajeRecibido = new ConsoleStringUtils();
        ConsoleIntegerUtils numeroRecibido = new ConsoleIntegerUtils();
        ConsoleDateUtils fechaRecibida = new ConsoleDateUtils();

        AgregarAlojamiento agregarAlojamiento = new AgregarAlojamiento(
                alojamientoRespository, mensajeRecibido, numeroRecibido, fechaRecibida
        );

        agregarAlojamiento.execute();

    }
}