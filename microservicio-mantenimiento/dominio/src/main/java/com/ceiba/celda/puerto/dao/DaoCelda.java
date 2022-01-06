package com.ceiba.celda.puerto.dao;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.modelo.entidad.Celda;

import java.util.List;

public interface DaoCelda {

    /**
     * Permite listar todas las celdas
     * @return lista*/

    List<DtoCelda> listarCeldas();
    List<DtoCelda> listarCeldasDisponibles();
    List<DtoCelda> listarCeldasDisponiblesTipoVehiculo(int id);
    DtoCelda buscarCeldaPorId(Long idCelda);
}
