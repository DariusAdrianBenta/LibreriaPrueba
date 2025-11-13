package com.libreria.Servicio;
// Gestionan la lógca de negocio , por ejemplo
// : Buscar un libro

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.libreria.Models.Libro;
import com.libreria.RepoLibros.InterfaceRepoLibro;

@Service
public class ServicioLibro implements InterfaceServicioLibro {
    private final InterfaceRepoLibro repoLibros;
    public ServicioLibro(InterfaceRepoLibro repoLibros){
        this.repoLibros = repoLibros;
    }

    @Override
    public List<Libro> allLibros() {
        return repoLibros.findAllLibros();

       
    }

    @Override
    public Optional<Libro> findById(long id) {
     repoLibros.findById(id);
     return repoLibros.findById(id);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        repoLibros.saveLibro(libro);
        return libro;
    }

    @Override
    public void deleteLibro(long id) {
        repoLibros.deleteLibro(id);
    }

    @Override
    public String findByTitulo(String titulo) {
       
       boolean encontrado = repoLibros.findAllLibros().stream()
        .anyMatch(l -> l.getTitulo() != null && l.getTitulo().equalsIgnoreCase(titulo));
        return encontrado ? "El libro '" + titulo + "' está disponible en la librería."
                         : "El libro '" + titulo + "' no se encuentra en la librería.";
    }
}
