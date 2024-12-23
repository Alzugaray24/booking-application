package com.booking.Models.reserva;

import com.booking.Models.alojamiento.Alojamiento;

import java.util.Date;
import java.util.List;

public class ReservaImplementacion implements IReserva {
    private Date horaDeLlegada;
    private Integer cantidadHabitaciones;
    private Cliente cliente;

    public ReservaImplementacion() {
    }

    public ReservaImplementacion(Date horaDeLlegada, Integer cantidadHabitaciones, Cliente cliente) {
        this.horaDeLlegada = horaDeLlegada;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.cliente = cliente;
    }

    @Override
    public void crearReserva(List<ReservaImplementacion> reservaData, Integer cantidadHabitaciones, Date horaDeLlegada) {

    }

    @Override
    public void eliminarReserva() {

    }

    @Override
    public void modificarReserva() {

    }


    @Override
    public void consultarReserva() {

    }

    public void mostrarReserva() {
        System.out.println("Hora de llegada: " + horaDeLlegada);
        System.out.println("Cantidad de habitaciones: " + cantidadHabitaciones);
        System.out.println("Cliente: " + cliente.getNombre());
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Date getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(Date horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}