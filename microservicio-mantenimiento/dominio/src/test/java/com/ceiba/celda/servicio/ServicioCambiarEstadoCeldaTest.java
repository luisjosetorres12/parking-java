package com.ceiba.celda.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;
import com.ceiba.celda.servicio.testdatabuilder.CeldaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionCeldaOcupada;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCambiarEstadoCeldaTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion el tipo de celda sea invalido")
    void deberiaDarErrorPorCeldaOcupada() {
        CeldaTestDataBuilder celdaTestDataBuilder = new CeldaTestDataBuilder().conEstadoCelda(0);
        BasePrueba.assertThrows(celdaTestDataBuilder::build, ExcepcionCeldaOcupada.class, "La celda seleccionada ya se encuentra ocupada");
    }

    @Test
    @DisplayName("Deberia actualizar el estado de una celda")
    void deberiaCambiarEstadoCelda() {
        Celda celdaTestDataBuilder = new CeldaTestDataBuilder().conEstadoCelda(1).build();
        Celda celdaNueva = new CeldaTestDataBuilder().conEstadoCelda(0).build();
        IRepositorioCelda repositorioCelda = Mockito.mock(IRepositorioCelda.class);
        Mockito.when(repositorioCelda.buscarCeldaId(Mockito.anyLong())).thenReturn(celdaTestDataBuilder);

        ServicioCambiarEstadoCelda servicioCambiarEstadoCelda = new ServicioCambiarEstadoCelda(repositorioCelda);
        servicioCambiarEstadoCelda.ejecutar(celdaNueva, 1L);
        Mockito.verify(repositorioCelda,Mockito.times(1)).cambiarEstadoCelda(celdaNueva);
    }
}
