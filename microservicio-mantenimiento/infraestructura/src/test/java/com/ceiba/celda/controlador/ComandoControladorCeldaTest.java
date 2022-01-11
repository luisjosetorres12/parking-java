package com.ceiba.celda.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.celda.comando.ComandoCelda;
import com.ceiba.celda.servicio.testdatabuilder.ComandoCeldaTestDataBuilder;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorCeldaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear una celda")
    void deberiaCrearCelda() throws Exception{
        ComandoCelda celda = new ComandoCeldaTestDataBuilder().build();

        mocMvc.perform(post("/celda")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(celda)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar una celda")
    void deberiaCambiarEstadoCelda() throws Exception {
        ComandoCelda celda = new ComandoCeldaTestDataBuilder().build();
        mocMvc.perform(put("/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(celda)))
                .andExpect(status().isOk());
    }
}
