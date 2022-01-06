package com.ceiba.celda.consulta;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.puerto.dao.DaoCelda;
import org.springframework.stereotype.Component;

import javax.xml.stream.events.DTD;
import java.util.List;

@Component
public class ManejadorListarCeldasTipoVehiculo {
    private final DaoCelda daoCelda;

    public ManejadorListarCeldasTipoVehiculo(DaoCelda daoCelda) {
        this.daoCelda = daoCelda;
    }

    public List<DtoCelda> ejecutar(int id) {
        return this.daoCelda.listarCeldasDisponiblesTipoVehiculo(id);
    }
}
