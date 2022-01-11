package com.ceiba.ticket.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket {
    private static final int VALOR_DEFAULT_TICKET = 0;
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
    private int estadoTicket;
    private float valorRecargaPorRetrasos;

    public Ticket(Long id, Long celdaId, float valor, float valorRecargaFestivos, float valorTotal, Date fechaEntrada, String documentoUsuario, String matriculaVehiculo, int tipoPlan) {
        this.id = id;
        this.celdaId = celdaId;
        this.valor = valor;
        this.valorRecargaFestivos = valorRecargaFestivos;
        this.valorTotal = valorTotal;
        this.fechaEntrada = (Date) fechaEntrada.clone();
        this.documentoUsuario = documentoUsuario;
        this.matriculaVehiculo = matriculaVehiculo;
        this.tipoPlan = tipoPlan;
        this.estadoTicket = VALOR_DEFAULT_TICKET;
        this.valorRecargaPorRetrasos = 0;
    }

}
