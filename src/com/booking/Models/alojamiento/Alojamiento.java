package com.booking.Models.alojamiento;

import com.booking.Models.habitacion.Habitacion;
import com.booking.Models.reserva.ReservaData;

import java.util.Date;
import java.util.List;

public abstract class Alojamiento {

    private String nombre;
    private String ciudad;
    private TipoAlojamiento tipo;
    private Float precioBase;
    private List<Habitacion> habitaciones;
    private Float calificacion;
    private Date fechaInicio;
    private Date fechaFin;

    public Alojamiento() {
    }

    public Alojamiento(String nombre, String ciudad, TipoAlojamiento tipo, Float precioBase, List<Habitacion> habitaciones, Float calificacion, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.precioBase = precioBase;
        this.habitaciones = habitaciones;
        this.calificacion = calificacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public TipoAlojamiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAlojamiento tipo) {
        this.tipo = tipo;
    }

    public Float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Float precioBase) {
        this.precioBase = precioBase;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public abstract void decorarHabiracion();


}