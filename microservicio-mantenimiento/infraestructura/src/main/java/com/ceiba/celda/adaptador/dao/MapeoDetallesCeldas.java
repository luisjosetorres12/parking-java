package com.ceiba.celda.adaptador.dao;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.modelo.dto.DtoListCeldas;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoDetallesCeldas implements RowMapper<DtoListCeldas>, MapperResult {
    @Override
    public DtoListCeldas mapRow(ResultSet rs, int rowNum) throws SQLException {
        String tipoCelda = rs.getString("tipoCelda");
        int cantidad = rs.getInt("quantity");
        int disponibles = rs.getInt("aviables");
        int ocupadas = rs.getInt("unaviables");
        return new DtoListCeldas(tipoCelda,cantidad,disponibles,ocupadas);
    }
}
