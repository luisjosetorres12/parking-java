package com.ceiba.celda.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.celda.comando.ComandoCelda;
import com.ceiba.celda.comando.fabrica.FabricaCelda;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.servicio.ServicioCambiarEstadoCelda;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCambiarEstadoCelda {
    private final FabricaCelda fabricaCelda;
    private final ServicioCambiarEstadoCelda cambiarEstadoCelda;

    public ManejadorCambiarEstadoCelda(FabricaCelda fabricaCelda, ServicioCambiarEstadoCelda cambiarEstadoCelda) {
        this.fabricaCelda = fabricaCelda;
        this.cambiarEstadoCelda = cambiarEstadoCelda;
    }

    public ComandoRespuesta<Boolean> ejecutar(ComandoCelda comandoCelda, Long id) {
        Celda celda = this.fabricaCelda.crear(comandoCelda);
        return new ComandoRespuesta<>(this.cambiarEstadoCelda.ejecutar(celda, id));
    }
}
