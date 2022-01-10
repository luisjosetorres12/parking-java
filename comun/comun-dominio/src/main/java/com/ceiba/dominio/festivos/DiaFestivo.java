package com.ceiba.dominio.festivos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class DiaFestivo {
    private Long id;
    private Date fechaFestivo;
    private String festividad;
}
