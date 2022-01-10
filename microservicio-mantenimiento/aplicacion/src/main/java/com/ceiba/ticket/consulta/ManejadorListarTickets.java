package com.ceiba.ticket.consulta;

import com.ceiba.ticket.modelo.dto.TicketDto;
import com.ceiba.ticket.puerto.dao.IDaoTicket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTickets {

    private final IDaoTicket daoTicket;

    public ManejadorListarTickets(IDaoTicket daoTicket) {
        this.daoTicket = daoTicket;
    }

    public List<TicketDto> ejecutar(){
        return this.daoTicket.listarTickets();
    }
}
