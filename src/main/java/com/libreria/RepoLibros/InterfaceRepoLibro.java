package com.libreria.RepoLibros;

import java.util.List;
import java.util.Optional;

import com.libreria.Models.Libro;

public interface InterfaceRepoLibro {
    List<Libro> findAllLibros();
    Optional<Libro> findById(long id);
    void saveLibro(Libro libro);
    void deleteLibro(long id);
    //Optional<Libro> findByTitulo(String titulo);

}
