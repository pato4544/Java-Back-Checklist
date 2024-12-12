package com.app.demo.controlers;

import com.app.demo.entities.Lista;
import com.app.demo.services.ServicioLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listaTareas")
@CrossOrigin("*")
public class ControladorLista {
    @Autowired
    private ServicioLista servicioLista;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Lista lista) {
        servicioLista.crear(lista);
        return ResponseEntity.ok("Se creo la tarea correctamente.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody boolean finalizada) {
        if (servicioLista.editaEstado(id, finalizada)) {
            return ResponseEntity.ok("La tarea ha finalizado");
        }
        return ResponseEntity.badRequest().body("No se encontro la tarea a editar");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (servicioLista.eliminar(id)) {
            return ResponseEntity.ok("Se ha eliminado correctamente");
        }
        return ResponseEntity.badRequest().body("No se pudo eliminar");
    }

    @GetMapping
    public ResponseEntity<?> mostrar() {
        return ResponseEntity.ok(servicioLista.mostrar());
    }
}
