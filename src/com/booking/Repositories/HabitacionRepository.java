package com.booking.Repositories;

import com.booking.Models.habitacion.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionRepository {
    private static HabitacionRepository instance;
    private List<Habitacion> habitaciones;

    private HabitacionRepository() {
        habitaciones = new ArrayList<>();
    }

    public static HabitacionRepository getInstance() {
        if (instance == null) {
            instance = new HabitacionRepository();
        }
        return instance;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void addHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }
}