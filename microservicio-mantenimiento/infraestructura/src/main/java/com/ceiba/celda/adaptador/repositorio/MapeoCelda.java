package com.ceiba.celda.adaptador.repositorio;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCelda implements RowMapper<Celda>, MapperResult {

    @Override
    public Celda mapRow(ResultSet rs, int rowNum) throws SQLException {
        int tipoVehiculo = rs.getInt("tipoVehiculo");
        Long id = rs.getLong("id");
        int estadoCelda = rs.getInt("estadoCelda");
        return new Celda(id,tipoVehiculo, estadoCelda);
    }
}
