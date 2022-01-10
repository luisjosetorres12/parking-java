package com.ceiba.ticket.adaptador.repository;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.ticket.modelo.entidad.DiaFestivo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoDiasFestivos implements RowMapper<DiaFestivo>, MapperResult {
    @Override
    public DiaFestivo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Date fechaFestivo = rs.getDate("fechaFestivo");
        String festividad = rs.getString("festividad");
        return new DiaFestivo(id, fechaFestivo, festividad);
    }
}
