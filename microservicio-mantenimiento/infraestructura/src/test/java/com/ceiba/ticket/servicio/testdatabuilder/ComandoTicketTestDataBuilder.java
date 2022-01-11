package com.ceiba.ticket.servicio.testdatabuilder;

import com.ceiba.ticket.comando.ComandoTicket;

import java.util.Date;

public class ComandoTicketTestDataBuilder {

    private final int VALOR_DEFAULT_TICKET = 0;
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

    public ComandoTicketTestDataBuilder(){
        this.celdaId = 1L;
        this.valor = 17;
        this.valorRecargaFestivos = 0;
        this.valorTotal = 17;
        this.fechaEntrada = new Date();
        this.documentoUsuario = "123456789";
        this.matriculaVehiculo = "ABC123";
        this.tipoPlan = 1;
        this.estadoTicket = VALOR_DEFAULT_TICKET;
        this.valorRecargaPorRetrasos = 0;
    }

    public ComandoTicketTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoTicket build(){
        return new ComandoTicket(
                id,
                celdaId,
                valor,
                valorRecargaFestivos,
                valorTotal,
                fechaEntrada,
                fechaSalida,
                documentoUsuario,
                matriculaVehiculo,
                tipoPlan
        );
    }
}
