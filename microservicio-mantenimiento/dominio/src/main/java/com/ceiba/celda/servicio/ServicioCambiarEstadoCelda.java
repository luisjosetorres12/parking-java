package com.ceiba.celda.servicio;

import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.modelo.entidad.Estado;
import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;
import com.ceiba.dominio.excepcion.ExcepcionCeldaOcupada;

public class ServicioCambiarEstadoCelda {

    private static final String CELDA_OCUPADA = "La celda seleccionada ya se encuentra ocupada";
    private final IRepositorioCelda repositorioCelda;

    public ServicioCambiarEstadoCelda(IRepositorioCelda repositorioCelda) {
        this.repositorioCelda = repositorioCelda;
    }

    public boolean ejecutar(Celda celda, Long idCelda){
        celda.setId(idCelda);
        Celda celdaEncontrada = this.repositorioCelda.buscarCeldaId(idCelda);
        if(celda.getEstadoCelda() == Estado.Ocupado.ordinal() && celdaEncontrada.getEstadoCelda() == Estado.Ocupado.ordinal()) {
            throw new ExcepcionCeldaOcupada(CELDA_OCUPADA);
        }
        this.repositorioCelda.cambiarEstadoCelda(celda);
        return true;
    }

}
