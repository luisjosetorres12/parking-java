package com.ceiba.ticket.consulta;

import com.ceiba.ticket.modelo.dto.TicketDto;
import com.ceiba.ticket.puerto.dao.IDaoTicket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTicketsMatricula {

    private final IDaoTicket daoTicket;

    public ManejadorListarTicketsMatricula(IDaoTicket daoTicket) {
        this.daoTicket = daoTicket;
    }

    public List<TicketDto> ejecutar(String matriculaVehiculo) {
        return this.daoTicket.obtenerTicketPorMatricula(matriculaVehiculo);
    }
}
