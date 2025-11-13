package com.libreria.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreria.Models.Libro;
import com.libreria.Servicio.InterfaceServicioLibro;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/libreria/libros")
public class ControladorLibreria {
    private final InterfaceServicioLibro interfazServicio;
  

    public ControladorLibreria( InterfaceServicioLibro interfazServicio){
        this.interfazServicio = interfazServicio;      
    }
   @GetMapping("/allLibros")
   public List<Libro> mostrarAllLibros() {
      return interfazServicio.allLibros();
   }
   @GetMapping("/id/{id}")
   public ResponseEntity<Libro> obtenerById(@PathVariable long id) {
   Optional<Libro> libro = interfazServicio.findById(id);
    return libro.map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.notFound().build());
   }
   @PostMapping("/guardar")
   public ResponseEntity<Libro> guardarNuevoLibro(@RequestBody Libro libro) {
       interfazServicio.saveLibro(libro);
       return ResponseEntity.ok(libro);
       
      
   }
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable long id) {
         interfazServicio.deleteLibro(id);
         return ResponseEntity.noContent().build();
    }
   
   
    

  
}
