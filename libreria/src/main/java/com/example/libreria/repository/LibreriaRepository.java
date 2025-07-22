package com.example.libreria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.libreria.model.Libreria;

@Repository
public interface LibreriaRepository extends CrudRepository<Libreria, Long> {}
