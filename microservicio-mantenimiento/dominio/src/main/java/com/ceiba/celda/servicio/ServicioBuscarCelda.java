package com.ceiba.celda.servicio;

import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

public class ServicioBuscarCelda {
    private final String CELDA_NO_ENCONTRADA = "La celda que desea no ha sido encontrada";
    private final IRepositorioCelda repositorioCelda;


    public ServicioBuscarCelda(IRepositorioCelda repositorioCelda) {
        this.repositorioCelda = repositorioCelda;
    }

    public Celda ejecutar(Long id) {
        Celda celdaFound = this.repositorioCelda.buscarCeldaId(id);
        if(celdaFound == null){
            throw new ExcepcionSinDatos(CELDA_NO_ENCONTRADA);
        }
        return celdaFound;
    }
}
