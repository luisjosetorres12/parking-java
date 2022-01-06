package com.ceiba.celda.comando.fabrica;

import com.ceiba.celda.comando.ComandoCelda;
import com.ceiba.celda.modelo.entidad.Celda;
import org.springframework.stereotype.Component;

@Component
public class FabricaCelda {

    public Celda crear(ComandoCelda comandoCelda) {
        return new Celda(
                comandoCelda.getId(),
                comandoCelda.getTipoVehiculo(),
                comandoCelda.getEstadoCelda()
        );
    }
}
