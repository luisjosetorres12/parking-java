package com.ceiba.celda.controlador;

import com.ceiba.celda.consulta.ManejadorBuscarCelda;
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
    private final ManejadorBuscarCelda manejadorBuscarCelda;

    public ConsultaControladorCelda(ManejadorListarCeldas manejadorListarCeldas, ManejadorListarCeldasDisponibles manejadorListarCeldasDisponibles, ManejadorListarCeldasTipoVehiculo manejadorListarCeldasTipoVehiculo, ManejadorBuscarCelda manejadorBuscarCelda) {
        this.manejadorListarCeldas = manejadorListarCeldas;
        this.manejadorListarCeldasDisponibles = manejadorListarCeldasDisponibles;
        this.manejadorListarCeldasTipoVehiculo = manejadorListarCeldasTipoVehiculo;
        this.manejadorBuscarCelda = manejadorBuscarCelda;
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
}
