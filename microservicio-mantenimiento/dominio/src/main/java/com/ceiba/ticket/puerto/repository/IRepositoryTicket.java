package com.ceiba.ticket.puerto.repository;

import com.ceiba.ticket.modelo.entidad.DiaFestivo;
import com.ceiba.ticket.modelo.entidad.Ticket;

import java.util.Date;
import java.util.List;

public interface IRepositoryTicket {
    Long crearTicket(Ticket ticket);
    Ticket actualizarTicket(Ticket ticket);
    boolean eliminarTicket(Long ticket);
    boolean deudaActual(String documentoUsuario);
    boolean matriculaActual(String matriculaVehiculo);
    List<DiaFestivo> diasFesvitos(Date fechaEntrada, Date fechaSalida);
}
