package com.ceiba.configuracion;

import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;
import com.ceiba.celda.servicio.ServicioCambiarEstadoCelda;
import com.ceiba.celda.servicio.ServicioCrearCelda;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCelda servicioCrearCelda(IRepositorioCelda repositorioCelda) {
        return new ServicioCrearCelda(repositorioCelda);
    }

    @Bean
    public ServicioCambiarEstadoCelda servicioCambiarEstadoCelda(IRepositorioCelda repositorioCelda) {
        return new ServicioCambiarEstadoCelda(repositorioCelda);
    }
	

}
