package com.ceiba.ticket.adaptador.dao;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ticket.modelo.dto.TicketDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTicket implements RowMapper<TicketDto>, MapperResult {
    @Override
    public TicketDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        float valor = rs.getFloat("valor");
        float valorRecargaFestivos = rs.getFloat("valorRecargaFestivos");
        float valorTotal = rs.getFloat("valorTotal");
        Date fechaEntrada = rs.getDate("fechaEntrada");
        Date fechaSalida = rs.getDate("fechaSalida");
        int tipoVehiculo = rs.getInt("tipoVehiculo");
        int estadoCelda = rs.getInt("estadoCelda");
        String documentoUsuario = rs.getString("cedulaUsuario");
        String matriculaVehiculo = rs.getString("matriculaVehiculo");
        Long celdaId = rs.getLong("celdaId");
        DtoCelda celda = new DtoCelda(celdaId, tipoVehiculo, estadoCelda);
        return new TicketDto(id, celda, valor, valorRecargaFestivos, valorTotal, fechaEntrada, fechaSalida, documentoUsuario, matriculaVehiculo);
    }
}
