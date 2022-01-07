package com.ceiba.celda.consulta;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.servicio.ServicioBuscarCelda;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarCelda {
    private final ServicioBuscarCelda servicioBuscarCelda;


    public ManejadorBuscarCelda(ServicioBuscarCelda servicioBuscarCelda) {
        this.servicioBuscarCelda = servicioBuscarCelda;
    }

    public DtoCelda ejecutar(Long id){
        Celda celda = this.servicioBuscarCelda.ejecutar(id);
        return new DtoCelda(celda.getId(),celda.getTipoVehiculo(),celda.getEstadoCelda());
    }
}
