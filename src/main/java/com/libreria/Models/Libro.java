package com.libreria.Models;

import java.time.LocalDate;

public class Libro implements Cloneable{
    private Long id;
    private String autor;
    private String titulo;
    private LocalDate fechaPubli;

 public Libro(Long id, String autor, String titulo, LocalDate fechaPubli) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.fechaPubli = fechaPubli;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
   
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    @Override
    public String toString() {
        return "Libro [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", fechaPubli=" + fechaPubli + "]";
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getFechaPubli() {
        return fechaPubli;
    }
    public void setFechaPubli(LocalDate fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    // ! 
    @Override
    public Libro clone(){
        try {
            return (Libro) super.clone();
        } catch (CloneNotSupportedException ERROR) { 
            throw new AssertionError();
        }        
    }

}
