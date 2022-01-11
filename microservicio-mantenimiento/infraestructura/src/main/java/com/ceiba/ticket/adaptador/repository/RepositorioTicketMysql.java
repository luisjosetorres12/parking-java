package com.ceiba.ticket.adaptador.repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ticket.modelo.entidad.DiaFestivo;
import com.ceiba.ticket.modelo.entidad.Ticket;
import com.ceiba.ticket.puerto.repository.IRepositoryTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RepositorioTicketMysql implements IRepositoryTicket {

    @SqlStatement(namespace="ticket", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "ticket", value = "deudaActual")
    private static String sqlDeudaActual;

    @SqlStatement(namespace = "ticket", value = "matriculaActual")
    private static String sqlMatriculaActual;

    @SqlStatement(namespace = "ticket", value = "diasFestivosEntreFechas")
    private static String sqlDiasFestivosEntreFechas;



    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioTicketMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearTicket(Ticket ticket) {
        System.out.println("EL valor es: "+ ticket.getValorRecargaPorRetrasos());
        return this.customNamedParameterJdbcTemplate.crear(ticket, sqlCrear);
    }

    @Override
    public Ticket actualizarTicket(Ticket ticket) {
        return null;
    }

    @Override
    public boolean eliminarTicket(Long ticket) {
        return false;
    }

    @Override
    public boolean deudaActual(String documentoUsuario) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("cedulaUsuario", documentoUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDeudaActual, mapSqlParameterSource, Boolean.class);
    }

    @Override
    public boolean matriculaActual(String matriculaVehiculo) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("matriculaVehiculo", matriculaVehiculo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlMatriculaActual, mapSqlParameterSource, Boolean.class);
    }

    @Override
    public List<DiaFestivo> diasFesvitos(Date fechaEntrada, Date fechaSalida) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("fechaEntrada", fechaEntrada);
        mapSqlParameterSource.addValue("fechaSalida", fechaSalida);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlDiasFestivosEntreFechas, mapSqlParameterSource, new MapeoDiasFestivos());
    }

}
