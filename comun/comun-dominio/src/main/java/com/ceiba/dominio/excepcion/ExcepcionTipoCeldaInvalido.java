package com.ceiba.dominio.excepcion;

public class ExcepcionTipoCeldaInvalido extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionTipoCeldaInvalido(String message) {
        super(message);
    }
}
