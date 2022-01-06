package com.ceiba.celda.puerto.repositorio;

import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.modelo.entidad.Estado;

public interface IRepositorioCelda {
    /**
     * Permite crear una celda
     * @param celda
     * @return id de celda
     */
    Long crearCelda(Celda celda);

    /**
     * Permite editar una celda
     * @param celda
     * @return la celda modificada
     */
    Celda actualizarCelda(Celda celda);

    /**
     * Permite eliminar una celda
     * @param celda
     * @return boolean*/
    boolean eliminarCelda(Celda celda);

    /**
     * Permite checkear el estado de una celda
     * @param celda
     * @return estado */
    Estado estadoCelda(Celda celda);

    /**
     * Permite cambiar el estado de una celda
     * @param celda
     * @return id de celda*/
    Celda cambiarEstadoCelda(Celda celda);

    /**
     * Permite buscar una celda por id
     * @param id
     * @return id de celda*/
    Celda buscarCeldaId(Long id);

}
