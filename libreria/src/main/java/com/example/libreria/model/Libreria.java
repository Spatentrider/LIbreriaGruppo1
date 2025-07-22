package com.example.libreria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "libreria")
public class Libreria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il titolo non può essere vuoto")
    @Size(min = 2, max = 100, message = "Il titolo deve essere tra 2 e 100 caratteri")
    @Column(nullable = false)
    private String titolo;

    @NotBlank(message = "L'autore non può essere vuoto")
    @Size(min = 2, max = 60, message = "Il nome dell'autore deve essere tra 2 e 60 caratteri")
    @Column(nullable = false)
    private String autore;

    @NotNull(message = "Il prezzo è obbligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "Il prezzo deve essere positivo")
    @Column(nullable = false)
    private Double prezzo;
}
