package com.gitt.pat.modelo;

import java.util.Objects;

public class ClaveConsejo {
    private String titulo;
    private String usuario;

    public ClaveConsejo(String titulo, String usuario) {
        this.titulo = titulo;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaveConsejo that = (ClaveConsejo) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(usuario, that.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, usuario);
    }
}

