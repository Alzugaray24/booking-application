package com.booking.Models.habitacion;

import java.util.List;

public class Habitacion {

    private List<String> tipoDeHabitacion;
    private Float precio;
    private String descripcion;
    private Boolean disponibilidad;
    private Integer cantidadMenores;
    private Integer cantidadAdultos;
    private Float precioBase;

    public Habitacion() {
    }

    public Habitacion(List<String> tipoDeHabitacion, Float precio, String descripcion, Boolean disponibilidad, Integer cantidadMenores, Integer cantidadAdultos, Float precioBase) {
        this.tipoDeHabitacion = tipoDeHabitacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.cantidadMenores = cantidadMenores;
        this.cantidadAdultos = cantidadAdultos;
        this.precioBase = precioBase;
    }

    public String toString() {
        return "Habitacion{" +
                "tipoDeHabitacion=" + tipoDeHabitacion +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", cantidadMenores=" + cantidadMenores +
                ", cantidadAdultos=" + cantidadAdultos +
                '}';
    }

    public List<String> getTipoDeHabitacion() {
        return tipoDeHabitacion;
    }

    public void setTipoDeHabitacion(List<String> tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Integer getCantidadMenores() {
        return cantidadMenores;
    }

    public void setCantidadMenores(Integer cantidadMenores) {
        this.cantidadMenores = cantidadMenores;
    }

    public Integer getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(Integer cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public Float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Float precioBase) {
        this.precioBase = precioBase;
    }
}