package com.booking.Repositories;

import com.booking.Models.alojamiento.Alojamiento;

import java.util.ArrayList;
import java.util.List;

public class AlojamientoRespository {
    private static AlojamientoRespository instance;
    private List<Alojamiento> alojamientos;

    private AlojamientoRespository() {
        alojamientos = new ArrayList<>();
    }

    public static AlojamientoRespository getInstance() {
        if (instance == null) {
            instance = new AlojamientoRespository();
        }
        return instance;
    }

    public List<Alojamiento> getAlojamientos() {
        return alojamientos;
    }

    public void addAlojamiento(Alojamiento alojamiento) {
        alojamientos.add(alojamiento);
    }


}