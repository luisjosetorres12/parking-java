package com.ceiba.celda.controlador;

import com.ceiba.celda.consulta.ManejadorListarCeldas;
import com.ceiba.celda.consulta.ManejadorListarCeldasDisponibles;
import com.ceiba.celda.consulta.ManejadorListarCeldasTipoVehiculo;
import com.ceiba.celda.modelo.dto.DtoCelda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/celda")
@Api(tags={"Controlador consulta celda"})
public class ConsultaControladorCelda {
    private final ManejadorListarCeldas manejadorListarCeldas;
    private final ManejadorListarCeldasDisponibles manejadorListarCeldasDisponibles;
    private final ManejadorListarCeldasTipoVehiculo manejadorListarCeldasTipoVehiculo;

    public ConsultaControladorCelda(ManejadorListarCeldas manejadorListarCeldas, ManejadorListarCeldasDisponibles manejadorListarCeldasDisponibles, ManejadorListarCeldasTipoVehiculo manejadorListarCeldasTipoVehiculo) {
        this.manejadorListarCeldas = manejadorListarCeldas;
        this.manejadorListarCeldasDisponibles = manejadorListarCeldasDisponibles;
        this.manejadorListarCeldasTipoVehiculo = manejadorListarCeldasTipoVehiculo;
    }

    @GetMapping
    @ApiOperation("Listar celdas")
    public List<DtoCelda> listarCeldas() {return this.manejadorListarCeldas.ejecutar();}

    @GetMapping("/disponibles")
    @ApiOperation("Listar Celdas Disponibles")
    public List<DtoCelda> listarCeldasDisponbles() {return  this.manejadorListarCeldasDisponibles.ejecutar();}

    @GetMapping("/disponibles-vehiculo/{tipoVehiculo}")
    @ApiOperation("Listar celdas disponibles por tipo vehiculo")
    public List<DtoCelda> listarCeldasDisponiblesTipoVehiculo(@PathVariable int tipoVehiculo) {
        return this.manejadorListarCeldasTipoVehiculo.ejecutar(tipoVehiculo);
    }
}
