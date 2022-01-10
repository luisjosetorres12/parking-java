package com.ceiba.celda.consulta;

import com.ceiba.celda.modelo.dto.DtoListCeldas;
import com.ceiba.celda.puerto.dao.DaoCelda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorDetallesCeldas {
    private final DaoCelda daoCelda;


    public ManejadorDetallesCeldas(DaoCelda daoCelda) {
        this.daoCelda = daoCelda;
    }

    public List<DtoListCeldas> ejecutar() {
        return this.daoCelda.listarCeldasTipo();
    }
}
