package com.ceiba.ticket.puerto.dao;

import com.ceiba.ticket.modelo.dto.TicketDto;

import java.util.List;

public interface IDaoTicket {
    List<TicketDto> listarTickets();
    TicketDto obtenerTicketPorId(Long id);
    List<TicketDto> obtenerTicketPorDocumentoUsuario(String documentoUsuario);
    List<TicketDto> obtenerTicketPorMatricula(String matriculaVehiculo);
}
