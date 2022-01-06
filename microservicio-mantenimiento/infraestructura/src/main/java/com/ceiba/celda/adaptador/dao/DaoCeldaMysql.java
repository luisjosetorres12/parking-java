package com.ceiba.celda.adaptador.dao;

import com.ceiba.celda.modelo.dto.DtoCelda;
import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.puerto.dao.DaoCelda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCeldaMysql implements DaoCelda {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="celda", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="celda", value="disponibles")
    private static String sqlListarDisponibles;

    @SqlStatement(namespace="celda", value="disponiblesTipoVehiculo")
    private static String sqlListarDisponiblesTipoVehiculo;

    @SqlStatement(namespace="celda", value="existePorId")
    private static String sqlExistePorId;

    public DaoCeldaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCelda> listarCeldas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCelda());
    }

    @Override
    public List<DtoCelda> listarCeldasDisponibles() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarDisponibles, new MapeoCelda());
    }

    @Override
    public List<DtoCelda> listarCeldasDisponiblesTipoVehiculo(int id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("tipoVehiculo", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarDisponiblesTipoVehiculo,parameterSource, new MapeoCelda());
    }

    @Override
    public DtoCelda buscarCeldaPorId(Long idCelda) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idCelda", idCelda);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,parameterSource, new MapeoCelda());
    }
}
