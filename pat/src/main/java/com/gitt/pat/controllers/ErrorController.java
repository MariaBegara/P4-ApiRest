package com.gitt.pat.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.gitt.pat.erroes.*;

@ControllerAdvice
public class ErrorController {

    // Errpr 404: Recurso no encontrado
    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<String> manejarRecursoNoEncontrado(RecursoNoEncontrado ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Error 400: Solicitud incorrecta
    @ExceptionHandler(ErrorSolicitud.class)
    public ResponseEntity<String> manejarSolicitudIncorrecta(ErrorSolicitud ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Error 500: Error interno del servidor
    @ExceptionHandler(MapaConsejosVacio.class)
    public ResponseEntity<String> manejarErrorInterno(MapaConsejosVacio ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Errores generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarErroresGenerales(Exception ex) {
        return new ResponseEntity<>("Error inesperado: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
