package com.ceiba.celda.servicio;

import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;

public class ServicioCrearCelda {

    private final IRepositorioCelda repositorioCelda;

    public ServicioCrearCelda(IRepositorioCelda repositorioCelda) {
        this.repositorioCelda = repositorioCelda;
    }

    public Long ejecutar(Celda celda){
        return this.repositorioCelda.crearCelda(celda);
    }
}
