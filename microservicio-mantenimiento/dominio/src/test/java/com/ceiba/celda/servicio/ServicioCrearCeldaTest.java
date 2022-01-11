package com.ceiba.celda.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.celda.servicio.testdatabuilder.CeldaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServicioCrearCeldaTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion el tipo de celda sea invalido")
    void deberiaLanzarUnErrorTipoCeldaInvalido() {
        CeldaTestDataBuilder celdaTestDataBuilder = new CeldaTestDataBuilder().conTipoVehiculo(3);
        BasePrueba.assertThrows(celdaTestDataBuilder::build, ExcepcionValorInvalido.class, "El tipo de celda es invalido");
    }
}
