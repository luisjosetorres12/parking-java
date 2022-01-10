package com.ceiba.celda.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Celda {

    private Long id;
    private int tipoVehiculo;
    private int estadoCelda;

    public Celda(Long id, int tipoVehiculo, int estadoCelda) {
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.estadoCelda = estadoCelda;
    }
}
