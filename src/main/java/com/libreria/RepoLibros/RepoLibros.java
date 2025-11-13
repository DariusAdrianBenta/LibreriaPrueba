package com.libreria.RepoLibros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.libreria.Models.Libro;

@Repository
public class RepoLibros implements InterfaceRepoLibro {
    private final List<Libro> libros = new ArrayList<>();
    public RepoLibros(){
libros.add(new Libro(1L, "Gabriel García Márquez", "Cien años de soledad", LocalDate.of(1967, 5, 30)));
libros.add(new Libro(2L, "Jane Austen", "Orgullo y prejuicio", LocalDate.of(1813, 1, 28)));
libros.add(new Libro(3L, "George Orwell", "1984", LocalDate.of(1949, 6, 8)));
libros.add(new Libro(4L, "Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 1)));
libros.add(new Libro(5L, "J.K. Rowling", "Harry Potter y la piedra filosofal", LocalDate.of(1997, 6, 26)));
libros.add(new Libro(6L, "Isabel Allende", "La casa de los espíritus", LocalDate.of(1982, 1, 1)));    

}
@Override
public List<Libro> findAllLibros(){
    return libros;
}

@Override
public Optional<Libro> findById(long id) {   
    return libros.stream()
    .filter(libro1 -> libro1.getId() == id )
    .findFirst();
}
@Override
public void saveLibro(Libro libro) {
    findById(libro.getId()).ifPresent(libros::remove);    
    libros.add(libro); 

    // TODO  --> COMO SE HARIA DE MANERA TRADICIONAL 
//  long id = libro.getId();
// if (!findById(id).isEmpty()) {
//     Libro existingLibro = findById(id).get(); 
//     libros.remove(existingLibro);             // 
//     libros.add(libro);                        // 
// }
}
@Override
public void deleteLibro(long id) {
  findById(id).ifPresent(libros::remove);
}
// @Override
// public Optional<Libro> findByTitulo(String titulo) {
//   return libros.stream()
//     .filter(libro1 -> libro1.getTitulo().equalsIgnoreCase(titulo))
//     .findFirst();
// }
  
}
