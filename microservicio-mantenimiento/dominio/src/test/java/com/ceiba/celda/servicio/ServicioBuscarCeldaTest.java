package com.ceiba.celda.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;
import com.ceiba.celda.servicio.testdatabuilder.CeldaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioBuscarCeldaTest {

    @Test
    @DisplayName("No Deberia encontrar una celda")
    void deberiaDarErrorPorCeldaNoEncontrada(){
        IRepositorioCelda repositorioCelda = Mockito.mock(IRepositorioCelda.class);
        Mockito.when(repositorioCelda.buscarCeldaId(Mockito.anyLong())).thenReturn(null);

        ServicioBuscarCelda servicioBuscarCelda = new ServicioBuscarCelda(repositorioCelda);
        BasePrueba.assertThrows(() -> servicioBuscarCelda.ejecutar(1L), ExcepcionSinDatos.class,"La celda que desea no ha sido encontrada");
    }

    @Test
    @DisplayName("Deberia encontrar una celda")
    void noDeberiaDarErrorPorCeldaNoEncontrada(){
        IRepositorioCelda repositorioCelda = Mockito.mock(IRepositorioCelda.class);
        Celda celdaNueva = new CeldaTestDataBuilder().conEstadoCelda(0).build();
        Mockito.when(repositorioCelda.buscarCeldaId(Mockito.anyLong())).thenReturn(celdaNueva);

        ServicioBuscarCelda servicioBuscarCelda = new ServicioBuscarCelda(repositorioCelda);
        servicioBuscarCelda.ejecutar(1l);
        Mockito.verify(repositorioCelda,Mockito.times(1)).buscarCeldaId(1L);
    }
}
