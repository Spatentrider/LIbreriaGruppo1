package com.example.libreria.controller;

import java.util.List;

import com.example.libreria.model.Libreria;
import com.example.libreria.service.LibreriaService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libreria")
public class LibreriaController {

    private final LibreriaService service;

    public LibreriaController(LibreriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libreria> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libreria> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libreria> create(@Valid @RequestBody Libreria nuovo) {
        Libreria creato = service.create(nuovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libreria> update(@PathVariable Long id, @Valid @RequestBody Libreria modificato) {
        return service.update(id, modificato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean rimosso = service.delete(id);
        return rimosso ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
