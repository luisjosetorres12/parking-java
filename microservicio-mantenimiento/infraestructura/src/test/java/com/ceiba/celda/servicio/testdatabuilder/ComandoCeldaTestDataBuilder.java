package com.ceiba.celda.servicio.testdatabuilder;

import com.ceiba.celda.comando.ComandoCelda;

public class ComandoCeldaTestDataBuilder {
    private Long id;
    private int tipoVehiculo;
    private int estadoCelda;

    public ComandoCeldaTestDataBuilder(){
        this.tipoVehiculo = 0;
        this.estadoCelda = 0;
    }

    public ComandoCeldaTestDataBuilder conEstadoCelda(int estadoCelda) {
        this.estadoCelda = estadoCelda;
        return this;
    }

    public ComandoCelda build() {return new ComandoCelda(this.id ,this.estadoCelda, this.tipoVehiculo);}
}
