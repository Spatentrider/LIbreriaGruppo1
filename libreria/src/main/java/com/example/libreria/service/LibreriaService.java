package com.example.libreria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.libreria.model.Libreria;
import com.example.libreria.repository.LibreriaRepository;

@Service
public class LibreriaService {

    private final LibreriaRepository repo;

    public LibreriaService(LibreriaRepository repo) {
        this.repo = repo;
    }

    public List<Libreria> getAll() {
        List<Libreria> lista = new ArrayList<>();
        repo.findAll().forEach(lista::add);
        return lista;
    }

    public Optional<Libreria> getById(Long id) {
        return repo.findById(id);
    }

    public Libreria create(Libreria nuovo) {
        return repo.save(nuovo);
    }

    public Optional<Libreria> update(Long id, Libreria modificato) {
        return repo.findById(id).map(l -> {
            l.setTitolo(modificato.getTitolo());
            l.setAutore(modificato.getAutore());
            l.setPrezzo(modificato.getPrezzo());
            return repo.save(l);
        });
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
