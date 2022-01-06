package com.ceiba.celda.adaptador.repositorio;

import com.ceiba.celda.modelo.entidad.Celda;
import com.ceiba.celda.modelo.entidad.Estado;
import com.ceiba.celda.puerto.repositorio.IRepositorioCelda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class RepositorioCeldaMysql implements IRepositorioCelda {

    @SqlStatement(namespace="celda", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="celda", value="cambiarEstado")
    private static String sqlCambiarEstado;

    @SqlStatement(namespace="celda", value="existePorId")
    private static String sqlExistePorId;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioCeldaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crearCelda(Celda celda) {
        return this.customNamedParameterJdbcTemplate.crear(celda, sqlCrear);
    }

    @Override
    public Celda actualizarCelda(Celda celda) {
        return null;
    }

    @Override
    public boolean eliminarCelda(Celda celda) {
        return false;
    }

    @Override
    public Estado estadoCelda(Celda celda) {
        return null;
    }

    @Override
    public Celda cambiarEstadoCelda(Celda celda) {
        this.customNamedParameterJdbcTemplate.actualizar(celda,sqlCambiarEstado);
        return celda;
    }

    public Celda buscarCeldaId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource,new MapeoCelda());
    }
}
