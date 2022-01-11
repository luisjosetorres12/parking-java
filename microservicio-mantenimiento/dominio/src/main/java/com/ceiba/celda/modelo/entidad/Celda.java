package com.ceiba.celda.modelo.entidad;

import lombok.Getter;
import lombok.Setter;
import static com.ceiba.dominio.ValidadorArgumento.validarTipoCelda;
@Getter
public class Celda {
    private static final String TIPO_DE_CELDA_INVALIDO = "El tipo de celda es invalido";
    private Long id;
    private int tipoVehiculo;
    private int estadoCelda;

    public Celda(Long id, int tipoVehiculo, int estadoCelda) {
        validarTipoCelda(tipoVehiculo, TIPO_DE_CELDA_INVALIDO);
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.estadoCelda = estadoCelda;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
