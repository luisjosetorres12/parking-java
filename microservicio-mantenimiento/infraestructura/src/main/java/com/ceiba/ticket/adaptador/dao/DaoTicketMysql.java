package com.ceiba.ticket.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.ticket.modelo.dto.TicketDto;
import com.ceiba.ticket.puerto.dao.IDaoTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTicketMysql implements IDaoTicket {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="ticket", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="ticket", value="listarPorDocumentoUsuario")
    private static String sqlTicketsPorDocumento;

    @SqlStatement(namespace="ticket", value="listarPorMatricula")
    private static String sqlTicketsPorMatricula;

    public DaoTicketMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<TicketDto> listarTickets() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTicket());
    }

    @Override
    public TicketDto obtenerTicketPorId(Long id) {
        return null;
    }

    @Override
    public List<TicketDto> obtenerTicketPorDocumentoUsuario(String documentoUsuario) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("cedulaUsuario", documentoUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlTicketsPorDocumento,mapSqlParameterSource ,new MapeoTicket());
    }

    @Override
    public List<TicketDto> obtenerTicketPorMatricula(String matriculaVehiculo) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("matriculaVehiculo", matriculaVehiculo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlTicketsPorMatricula, mapSqlParameterSource, new MapeoTicket());
    }
}
