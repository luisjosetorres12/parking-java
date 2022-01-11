package com.ceiba.celda.entidad;

import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.servicio.testdatabuilder.CeldaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CeldaTest {

    @Test
    @DisplayName("Deberia crear correctamente la celda")
    void deberiaConstruirLaCeldaCorrectamente(){
        Celda celda = new CeldaTestDataBuilder().conId(1L).build();

        assertEquals(celda.getEstadoCelda(), 1);
        assertEquals(celda.getTipoVehiculo(), 1);
        assertEquals(celda.getId(), 1L);
    }
}
