package com.ceiba.ticket.servicio;

import java.util.Calendar;
import java.util.Date;
import static com.ceiba.ticket.modelo.entidad.Planes.*;

public class ServicioCalcularFechaSalida {

    public Date ejecutar(Date fechaEntrada, int tipoPlan) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaEntrada);
        Date fechaSalida = new Date();
        switch (tipoPlan) {
            case PLAN_DIA:
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                fechaSalida = calendar.getTime();
                break;
            case PLAN_SEMANA:
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                fechaSalida =  calendar.getTime();
                break;
            case PLAN_MES:
                calendar.add(Calendar.MONTH, 1);
                fechaSalida = calendar.getTime();
                break;
        }
        return fechaSalida;
    }
}
