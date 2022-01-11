package com.ceiba.celda.controlador;

import com.ceiba.ApplicationMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorCelda.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorCeldaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia listar las celdas")
    void deberiaListarCeldas() throws Exception {
        mocMvc.perform(get("/celda")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].tipovehiculo", is(0)))
                .andExpect(jsonPath("$[0].estadoCelda", is(0)))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    @DisplayName("Deberia listar las celdas disponibles")
    void deberiaListarCeldasDisponibles() throws Exception {
        mocMvc.perform(get("/celda/disponibles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].tipovehiculo", is(0)))
                .andExpect(jsonPath("$[0].estadoCelda", is(1)))
                .andExpect(jsonPath("$[0].id", is(2)));
    }

    @Test
    @DisplayName("Deberia listar las celdas disponibles por tipo vehiculo")
    void deberiaListarCeldasDisponiblesVehiculo() throws Exception {
        mocMvc.perform(get("/celda/disponibles-vehiculo/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].tipovehiculo", is(0)))
                .andExpect(jsonPath("$[0].estadoCelda", is(1)))
                .andExpect(jsonPath("$[0].id", is(2)));
    }

    @Test
    @DisplayName("Deberia obtener una celda")
    void deberiaObtenerUnaCelda() throws Exception {
        mocMvc.perform(get("/celda/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipovehiculo", is(0)))
                .andExpect(jsonPath("$.estadoCelda", is(0)))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    @DisplayName("Deberia obtener los detalles")
    void deberiaObtenerDetalles() throws Exception {
        mocMvc.perform(get("/celda/detalles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
