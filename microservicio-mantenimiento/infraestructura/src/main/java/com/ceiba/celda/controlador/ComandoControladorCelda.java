package com.ceiba.celda.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.celda.comando.ComandoCelda;
import com.ceiba.celda.comando.manejador.ManejadorCambiarEstadoCelda;
import com.ceiba.celda.comando.manejador.ManejadorCrearCelda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/celda")
@Api(tags = { "Controlador comando celda"})
public class ComandoControladorCelda {

    private final ManejadorCrearCelda manejadorCrearCelda;
    private final ManejadorCambiarEstadoCelda manejadorCambiarEstadoCelda;

    @Autowired
    public ComandoControladorCelda(ManejadorCrearCelda manejadorCrearCelda, ManejadorCambiarEstadoCelda manejadorCambiarEstadoCelda) {
        this.manejadorCrearCelda = manejadorCrearCelda;
        this.manejadorCambiarEstadoCelda = manejadorCambiarEstadoCelda;
    }

    @PostMapping
    @ApiOperation("crear celda")
    public ComandoRespuesta<Long> crearCelda(@RequestBody ComandoCelda comandoCelda) {
        return manejadorCrearCelda.ejecutar(comandoCelda);
    }

    @PutMapping(value = "/{idCelda}")
    @ApiOperation("Cambiar estado de celda")
    public ComandoRespuesta<Boolean> cambiarEstadoCelda(@RequestBody ComandoCelda comandoCelda, @PathVariable Long idCelda) {
        return this.manejadorCambiarEstadoCelda.ejecutar(comandoCelda, idCelda);
    }
}
