package com.gitt.pat.controllers;

import com.gitt.pat.erroes.*;
import com.gitt.pat.modelo.ClaveConsejo;
import com.gitt.pat.modelo.ModeloFormularioContacto;

import jakarta.validation.Valid;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/consejos") // Añadiendo esto, me ahorror tener que poner /api/consejos en todos los métodos
// Se habilitan las peticiones desde la página de pages desplegada:
//@CrossOrigin(origins = "https://mariabegara.github.io/p4")
@CrossOrigin(origins = {"http://127.0.0.1:3000", "http://localhost:3000"})


public class ControladorRest
{
    private final Map<ClaveConsejo, ModeloFormularioContacto> consejos = new HashMap<>();


    @PostConstruct
    public void inicializarConsejos() {
        // Añado algunos consejos de prueba
        consejos.put(
                new ClaveConsejo("Consejo 1", "Usuario1"),
                new ModeloFormularioContacto("Consejo 1", "Usuario1", "Este es un consejo muy útil."));

        consejos.put(
                new ClaveConsejo("Consejo 2", "Usuario2"),
                new ModeloFormularioContacto("Consejo 2", "Usuario2", "Otro consejo útil aquí."));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloFormularioContacto crearConsejo(
            @Valid
            @RequestBody ModeloFormularioContacto consejoNuevo) {
        ClaveConsejo clave = new ClaveConsejo(consejoNuevo.titulo(), consejoNuevo.usuario());
        consejos.put(clave, consejoNuevo);
        return consejoNuevo;
    }

    @GetMapping("")
    public Collection<ModeloFormularioContacto> obtenerTodosLosConsejos() {
        // Se verifica si el mapa está vacío
        if (consejos.isEmpty()) {
            // Lanza una excepción si no hay consejos
            throw new MapaConsejosVacio("No hay consejos disponibles.");
        }
        return consejos.values(); // Devuelve todos los consejos almacenados en el mapa
    }

    @PutMapping("/titulo/{titulo}/usuario/{usuario}")
    public ModeloFormularioContacto modificarConsejo(
            @PathVariable String titulo,
            @PathVariable String usuario,
            @RequestBody Map<String, String> modificacion) {

        // Creo la clave compuesta: título, usuario
        ClaveConsejo clave = new ClaveConsejo(titulo, usuario);

        // Consejo almacenado en la API (antes del cambio)
        ModeloFormularioContacto consejoActual = consejos.get(clave);

        if (consejoActual == null) {
            throw new RecursoNoEncontrado("Consejo no encontrado para el título: " + titulo + " y usuario: " + usuario);
        }

        String nuevoMensaje = modificacion.get("mensaje");

        ModeloFormularioContacto consejoModificado =
                new ModeloFormularioContacto(
                        consejoActual.titulo(), // Se mantiene el título
                        consejoActual.usuario(), // Se mantiene el usuario
                        nuevoMensaje);
        consejos.put(clave, consejoModificado);
        return consejoModificado;
    }

    @DeleteMapping("/titulo/{titulo}/usuario/{usuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarConsejo(
            @PathVariable String titulo,
            @PathVariable String usuario) {
        ClaveConsejo clave = new ClaveConsejo(titulo, usuario);
        consejos.remove(clave);
    }
}

