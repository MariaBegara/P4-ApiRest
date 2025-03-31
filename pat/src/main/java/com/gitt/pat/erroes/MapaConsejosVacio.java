package com.gitt.pat.erroes;

public class MapaConsejosVacio extends RuntimeException {
    public MapaConsejosVacio(String mensaje) {
        super(mensaje);
    }
}