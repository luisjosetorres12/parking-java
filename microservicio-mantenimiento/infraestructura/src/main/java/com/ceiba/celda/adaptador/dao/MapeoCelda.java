package com.ceiba.celda.adaptador.dao;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCelda implements RowMapper<DtoCelda>, MapperResult {

    @Override
    public DtoCelda mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        int tipoVehiculo = resultSet.getInt("tipoVehiculo");
        int estadoCelda = resultSet.getInt("estadoCelda");

        return new DtoCelda(id, tipoVehiculo,estadoCelda);
    }
}
