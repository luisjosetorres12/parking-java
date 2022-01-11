package com.ceiba.ticket.servicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCalcularFechaSalidaTest {

    @Test
    @DisplayName("Deberia calcular la fecha de salida de 1 dia")
    void calcularFechaSalidaPlanDia(){
        Calendar myCal = Calendar.getInstance();
        myCal.set(2022,01,01);
        ServicioCalcularFechaSalida servicioCalcularFechaSalida = new ServicioCalcularFechaSalida();
        Date fechaEntrada = myCal.getTime();
        myCal.set(2022,01,02);
        Date fechaSalidaEsperada = myCal.getTime();
        Date fechaSalida = servicioCalcularFechaSalida.ejecutar(fechaEntrada,1);
        assertEquals(fechaSalida, fechaSalidaEsperada);
    }

    @Test
    @DisplayName("Deberia calcular la fecha de salida de 1 semana")
    void calcularFechaSalidaPlanSemana(){
        Calendar myCal = Calendar.getInstance();
        myCal.set(2022,01,01);
        ServicioCalcularFechaSalida servicioCalcularFechaSalida = new ServicioCalcularFechaSalida();
        Date fechaEntrada = myCal.getTime();
        myCal.set(2022,01,8);
        Date fechaSalidaEsperada = myCal.getTime();
        Date fechaSalida = servicioCalcularFechaSalida.ejecutar(fechaEntrada,2);
        assertEquals(fechaSalida, fechaSalidaEsperada);
    }

    @Test
    @DisplayName("Deberia calcular la fecha de salida de 1 mes")
    void calcularFechaSalidaPlanMes(){
        Calendar myCal = Calendar.getInstance();
        myCal.set(2022,01,01);
        ServicioCalcularFechaSalida servicioCalcularFechaSalida = new ServicioCalcularFechaSalida();
        Date fechaEntrada = myCal.getTime();
        myCal.set(2022,02,01);
        Date fechaSalidaEsperada = myCal.getTime();
        Date fechaSalida = servicioCalcularFechaSalida.ejecutar(fechaEntrada,3);
        assertEquals(fechaSalida, fechaSalidaEsperada);
    }
}
