package com.ceiba.celda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCelda {
    private Long id;
    private int tipoVehiculo;
    private int estadoCelda;
}
