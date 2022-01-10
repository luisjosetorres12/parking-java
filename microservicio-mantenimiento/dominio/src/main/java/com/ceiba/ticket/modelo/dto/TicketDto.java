package com.ceiba.ticket.modelo.dto;

import com.ceiba.celda.modelo.dto.DtoCelda;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class TicketDto {
    private Long id;
    private DtoCelda celda;
    private float valor;
    private float valorRecargaFestivos;
    private float valorTotal;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String documentoUsuario;
    private String matriculaVehiculo;
}
