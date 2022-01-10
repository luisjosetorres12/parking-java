package com.ceiba.celda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoListCeldas {
    private String tipoCelda;
    private int cantidad;
    private int disponibles;
    private int ocupadas;
}
