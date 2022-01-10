package com.ceiba.ticket.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.ticket.modelo.entidad.DiaFestivo;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.repository.IRepositoryTicket;

import java.util.Date;
import java.util.List;

public class ServicioCrearTicket {

    public static final String CLIENTE_CON_TICKET_ABIERTO = "El cliente tiene un ticket en este momento";
    public static final String MATRICULA_REGISTRADA_ACTUALMENTE = "La matricula ingresada esta asociada a un ticket vigente";
    private final IRepositoryTicket repositoryTicket;
    private final ServicioCalcularFechaSalida servicioCalcularFechaSalida;

    public ServicioCrearTicket(IRepositoryTicket repositoryTicket, ServicioCalcularFechaSalida servicioCalcularFechaSalida) {
        this.repositoryTicket = repositoryTicket;
        this.servicioCalcularFechaSalida = servicioCalcularFechaSalida;
    }

    public Long ejecutar(Ticket ticket){
        validarDeudaActual(ticket.getDocumentoUsuario());
        validarMatricula(ticket.getMatriculaVehiculo());
        ticket.setFechaSalida(this.servicioCalcularFechaSalida.ejecutar(ticket.getFechaEntrada(), ticket.getTipoPlan()));
        float extras = recargoPorDiasFestivos(ticket.getFechaEntrada(), ticket.getFechaSalida());
        ticket.setValorRecargaFestivos(extras);
        return this.repositoryTicket.crearTicket(ticket);
    }

    public void validarDeudaActual(String documentoUsuario){
        boolean tieneDeuda = this.repositoryTicket.deudaActual(documentoUsuario);
        if (tieneDeuda) {
            throw new ExcepcionDuplicidad(CLIENTE_CON_TICKET_ABIERTO);
        }
    }

    public void validarMatricula(String matriculaVehiculo) {
        boolean matriculaExiste = this.repositoryTicket.matriculaActual(matriculaVehiculo);
        if(matriculaExiste) {
            throw new ExcepcionDuplicidad(MATRICULA_REGISTRADA_ACTUALMENTE);
        }
    }

    public float recargoPorDiasFestivos(Date fechaEntrada, Date fechaSalida) {
        List<DiaFestivo> diasFestivos = this.repositoryTicket.diasFesvitos(fechaEntrada, fechaSalida);
        return 250 * diasFestivos.size();

    }
}
