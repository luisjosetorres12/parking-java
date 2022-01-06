package com.ceiba.dominio.excepcion;

public class ExcepcionCeldaOcupada extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionCeldaOcupada(String mensaje) {
        super(mensaje);
    }

}
