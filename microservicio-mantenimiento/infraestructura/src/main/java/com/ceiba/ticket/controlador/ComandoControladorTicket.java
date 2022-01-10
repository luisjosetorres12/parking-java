package com.ceiba.ticket.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ticket.comando.ComandoTicket;
import com.ceiba.ticket.comando.manejador.ManejadorCrearTicket;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/ticket")
@Api(tags={"Controlador comando ticket"})
public class ComandoControladorTicket {

    private final ManejadorCrearTicket manejadorCrearTicket;

    public ComandoControladorTicket(ManejadorCrearTicket manejadorCrearTicket) {
        this.manejadorCrearTicket = manejadorCrearTicket;
    }

    @PostMapping
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTicket comandoTicket) {
        return this.manejadorCrearTicket.ejecutar(comandoTicket);
    }
}
