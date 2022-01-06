package com.ceiba.celda.consulta;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.puerto.dao.DaoCelda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCeldasDisponibles {

    public final DaoCelda daoCelda;

    public ManejadorListarCeldasDisponibles(DaoCelda daoCelda) {
        this.daoCelda = daoCelda;
    }

    public List<DtoCelda> ejecutar(){
        return this.daoCelda.listarCeldasDisponibles();
    }
}
