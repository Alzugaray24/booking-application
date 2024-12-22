package com.booking.Models.alojamiento;

import com.booking.Models.habitacion.Habitacion;
import com.booking.Models.reserva.ReservaData;

import java.util.Date;
import java.util.List;

public class DiaDeSol extends Alojamiento {

    private Boolean incluyeAlmuerzo;
    private Boolean incluyeRefrigerio;

    public DiaDeSol() {
    }

    @Override
    public void decorarHabiracion() {
        System.out.println("Decorando habitación de día de sol");
    }


    public DiaDeSol(String nombre, String ciudad, TipoAlojamiento tipo, Double precioBase, List<Habitacion> habitaciones, Integer calificacion, Date fechaInicio, Date fechaFin, Boolean incluyeAlmuerzo, Boolean incluyeRefrigerio) {
        super(nombre, ciudad, tipo, precioBase, habitaciones, calificacion, fechaInicio, fechaFin);
        this.incluyeAlmuerzo = incluyeAlmuerzo;
        this.incluyeRefrigerio = incluyeRefrigerio;
    }

    public Boolean getIncluyeAlmuerzo() {
        return incluyeAlmuerzo;
    }

    public void setIncluyeAlmuerzo(Boolean incluyeAlmuerzo) {
        this.incluyeAlmuerzo = incluyeAlmuerzo;
    }

    public Boolean getIncluyeRefrigerio() {
        return incluyeRefrigerio;
    }

    public void setIncluyeRefrigerio(Boolean incluyeRefrigerio) {
        this.incluyeRefrigerio = incluyeRefrigerio;
    }
}