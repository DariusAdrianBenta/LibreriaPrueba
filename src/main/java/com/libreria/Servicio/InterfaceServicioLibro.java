package com.libreria.Servicio;

import java.util.List;
import java.util.Optional;

import com.libreria.Models.Libro;

public interface InterfaceServicioLibro {
List<Libro> allLibros();
Optional<Libro> findById(long id);
Libro saveLibro(Libro libro);
void deleteLibro(long id);
String findByTitulo(String titulo);
}
