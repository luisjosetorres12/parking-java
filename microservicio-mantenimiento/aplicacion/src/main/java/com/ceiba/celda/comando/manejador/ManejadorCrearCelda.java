package com.ceiba.celda.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.celda.comando.ComandoCelda;
import com.ceiba.celda.comando.fabrica.FabricaCelda;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.servicio.ServicioCrearCelda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCelda implements ManejadorComandoRespuesta<ComandoCelda, ComandoRespuesta<Long>> {
    private final FabricaCelda fabricaCelda;
    private final ServicioCrearCelda servicioCrearCelda;


    public ManejadorCrearCelda(FabricaCelda fabricaCelda, ServicioCrearCelda servicioCrearCelda) {
        this.fabricaCelda = fabricaCelda;
        this.servicioCrearCelda = servicioCrearCelda;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCelda comandoCelda) {
        Celda celda = this.fabricaCelda.crear(comandoCelda);
        return new ComandoRespuesta<>(this.servicioCrearCelda.ejecutar(celda));
    }
}
