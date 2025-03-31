package com.gitt.pat.erroes;

public class ErrorSolicitud extends RuntimeException {
    public ErrorSolicitud(String mensaje) {
        super(mensaje);
    }
}
