package com.ceiba.celda.servicio.testdatabuilder;

import com.ceiba.celda.modelo.entidad.Celda;

public class CeldaTestDataBuilder {

    private Long id;
    private int tipoVehiculo;
    private int estadoCelda;

    public CeldaTestDataBuilder(){
        this.tipoVehiculo = 1;
        this.estadoCelda = 2;
    }

    public CeldaTestDataBuilder conTipoVehiculo(int tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public Celda build() {return new Celda(id,tipoVehiculo,estadoCelda);}
}
