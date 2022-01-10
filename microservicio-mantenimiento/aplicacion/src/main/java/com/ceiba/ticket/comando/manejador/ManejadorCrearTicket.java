package com.ceiba.ticket.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.ticket.comando.ComandoTicket;
import com.ceiba.ticket.comando.fabrica.FabricaTicket;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.servicio.ServicioCrearTicket;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTicket implements ManejadorComandoRespuesta<ComandoTicket, ComandoRespuesta<Long>> {

    private final FabricaTicket fabricaTicket;
    private final ServicioCrearTicket servicioCrearTicket;

    public ManejadorCrearTicket(FabricaTicket fabricaTicket, ServicioCrearTicket servicioCrearTicket) {
        this.fabricaTicket = fabricaTicket;
        this.servicioCrearTicket = servicioCrearTicket;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoTicket comando) {
        Ticket ticket = this.fabricaTicket.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearTicket.ejecutar(ticket));
    }
}
