package com.gitt.pat.modelo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ModeloFormularioContacto(
        @NotBlank(message = "El consejo no puede crearse sin título")
        String titulo,

        @NotBlank(message = "El usuario no puede estar vacío")
        String usuario,

        @NotBlank(message = "El mensaje es obligatorio")
        @Size(min = 20, max = 300, message = "El mensaje debe tener entre 20 y 300 palabras")
        String mensaje
) {}



