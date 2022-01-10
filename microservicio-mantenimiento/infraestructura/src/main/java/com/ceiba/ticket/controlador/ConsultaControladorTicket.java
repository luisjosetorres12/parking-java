package com.ceiba.ticket.controlador;

import com.ceiba.ticket.consulta.ManejadorListarTickets;
import com.ceiba.ticket.consulta.ManejadorListarTicketsMatricula;
import com.ceiba.ticket.consulta.ManejadorListarTicketsUsuario;
import com.ceiba.ticket.modelo.dto.TicketDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/ticket")
@Api(tags={"Controlador consulta ticket"})
public class ConsultaControladorTicket {

    private final ManejadorListarTickets manejadorListarTickets;
    private final ManejadorListarTicketsUsuario manejadorListarTicketsUsuario;
    private final ManejadorListarTicketsMatricula manejadorListarTicketsMatricula;

    public ConsultaControladorTicket(ManejadorListarTickets manejadorListarTickets, ManejadorListarTicketsUsuario manejadorListarTicketsUsuario, ManejadorListarTicketsMatricula manejadorListarTicketsMatricula) {
        this.manejadorListarTickets = manejadorListarTickets;
        this.manejadorListarTicketsUsuario = manejadorListarTicketsUsuario;
        this.manejadorListarTicketsMatricula = manejadorListarTicketsMatricula;
    }

    @GetMapping
    @ApiOperation("Listar Tickets")
    public List<TicketDto> listarTickets(){
        return this.manejadorListarTickets.ejecutar();
    }

    @GetMapping("by-user/{documentoUsuario}")
    @ApiOperation("Listar tickts por usuario")
    public List<TicketDto> listarTicketsPorUsuario(@PathVariable String documentoUsuario){
        return this.manejadorListarTicketsUsuario.ejecutar(documentoUsuario);
    }

    @GetMapping("by-matricula/{matriculaVehiculo}")
    @ApiOperation("Listar tickets por matricula")
    public List<TicketDto> listarTicketsPorMatricula(@PathVariable String matriculaVehiculo) {
        return this.manejadorListarTicketsMatricula.ejecutar(matriculaVehiculo);
    }
}
