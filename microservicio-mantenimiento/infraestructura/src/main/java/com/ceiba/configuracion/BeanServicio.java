package com.ceiba.configuracion;

import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;
import com.ceiba.celda.servicio.ServicioBuscarCelda;
import com.ceiba.celda.servicio.ServicioCambiarEstadoCelda;
import com.ceiba.celda.servicio.ServicioCrearCelda;
import com.ceiba.ticket.puerto.repository.IRepositoryTicket;
import com.ceiba.ticket.servicio.ServicioCalcularFechaSalida;
import com.ceiba.ticket.servicio.ServicioCrearTicket;
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

    @Bean
    public ServicioBuscarCelda servicioBuscarCelda(IRepositorioCelda repositorioCelda) {
        return new ServicioBuscarCelda(repositorioCelda);
    }

    @Bean
    public ServicioCrearTicket servicioCrearTicket(IRepositoryTicket repositoryTicket, ServicioCalcularFechaSalida servicioCalcularFechaSalida) {
        return new ServicioCrearTicket(repositoryTicket, servicioCalcularFechaSalida);
    }

    @Bean
    public ServicioCalcularFechaSalida servicioCalcularFechaSalida(){
        return new ServicioCalcularFechaSalida();
    }

}
