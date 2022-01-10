package com.ceiba.ticket.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTicket {
    private Long id;
    private Long celdaId;
    private float valor;
    private float valorRecargaFestivos;
    private float valorTotal;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String documentoUsuario;
    private String matriculaVehiculo;
    private int tipoPlan;
}
