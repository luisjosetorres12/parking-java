package com.ceiba.ticket.comando.fabrica;

import com.ceiba.ticket.comando.ComandoTicket;
import com.ceiba.ticket.modelo.entidad.Ticket;
import org.springframework.stereotype.Component;

@Component
public class FabricaTicket {

    public Ticket crear(ComandoTicket comandoTicket) {
        return new Ticket(
                comandoTicket.getId(),
                comandoTicket.getCeldaId(),
                comandoTicket.getValor(),
                comandoTicket.getValorRecargaFestivos(),
                comandoTicket.getValorTotal(),
                comandoTicket.getFechaEntrada(),
                comandoTicket.getDocumentoUsuario(),
                comandoTicket.getMatriculaVehiculo(),
                comandoTicket.getTipoPlan()
        );
    }
}
