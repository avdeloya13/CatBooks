package com.example.tarea_2;

import java.io.Serializable;

public class Book implements Serializable {

    private int idImagen;
    private String titulo;
    private String autor;

    public Book(int idImagen, String titulo, String autor) {
        this.idImagen = idImagen;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getIdImagen() {
        return idImagen;
    }
}
