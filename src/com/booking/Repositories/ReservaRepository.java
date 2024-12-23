package com.booking.Repositories;

import com.booking.Models.reserva.ReservaImplementacion;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private static ReservaRepository instance;
    private List<ReservaImplementacion> reservas;

    private ReservaRepository() {
        reservas = new ArrayList<>();
    }

    public static ReservaRepository getInstance() {
        if (instance == null) {
            instance = new ReservaRepository();
        }
        return instance;
    }

    public List<ReservaImplementacion> getReservas() {
        return reservas;
    }

    public void addReserva(ReservaImplementacion reserva) {
        reservas.add(reserva);
    }
}