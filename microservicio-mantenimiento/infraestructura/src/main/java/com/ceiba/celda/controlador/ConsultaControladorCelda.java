package com.ceiba.celda.controlador;

import com.ceiba.celda.consulta.*;
import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.modelo.dto.DtoListCeldas;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/celda")
@Api(tags={"Controlador consulta celda"})
public class ConsultaControladorCelda {
    private final ManejadorListarCeldas manejadorListarCeldas;
    private final ManejadorListarCeldasDisponibles manejadorListarCeldasDisponibles;
    private final ManejadorListarCeldasTipoVehiculo manejadorListarCeldasTipoVehiculo;
    private final ManejadorBuscarCelda manejadorBuscarCelda;
    private final ManejadorDetallesCeldas manejadorDetallesCeldas;

    public ConsultaControladorCelda(ManejadorListarCeldas manejadorListarCeldas, ManejadorListarCeldasDisponibles manejadorListarCeldasDisponibles, ManejadorListarCeldasTipoVehiculo manejadorListarCeldasTipoVehiculo, ManejadorBuscarCelda manejadorBuscarCelda, ManejadorDetallesCeldas manejadorDetallesCeldas) {
        this.manejadorListarCeldas = manejadorListarCeldas;
        this.manejadorListarCeldasDisponibles = manejadorListarCeldasDisponibles;
        this.manejadorListarCeldasTipoVehiculo = manejadorListarCeldasTipoVehiculo;
        this.manejadorBuscarCelda = manejadorBuscarCelda;
        this.manejadorDetallesCeldas = manejadorDetallesCeldas;
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

    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener una celda")
    public DtoCelda obtenerCelda(@PathVariable Long id){
        return this.manejadorBuscarCelda.ejecutar(id);
    }

    @GetMapping("/detalles")
    @ApiOperation("Obtener detalles de celdas")
    public List<DtoListCeldas> detallesCeldas() {
        return this.manejadorDetallesCeldas.ejecutar();
    }
}
