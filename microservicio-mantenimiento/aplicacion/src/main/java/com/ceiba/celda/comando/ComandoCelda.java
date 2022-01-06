package com.ceiba.celda.comando;

import com.ceiba.celda.modelo.entidad.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCelda {
    private Long id;
    private int tipoVehiculo;
    private int estadoCelda;
}
