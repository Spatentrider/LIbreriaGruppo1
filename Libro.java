package com.example.libreria.model;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descrizione", nullable = false, length = 100)
    private String titolo;
    private String autore;
    private double prezzo;

    public Libro(String titolo, String autore, double prezzo) {
    this.titolo = titolo;
    this.autore = autore;
    this.prezzo = prezzo;
}
     
}
