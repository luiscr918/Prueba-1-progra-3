package com.itsqmet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
@Size(min = 5, max = 45)
    @NotBlank
    private String nombre;
    @Size(min = 10, max = 100)
    private String descripcion;

    @Pattern(regexp = "^\\d+(\\.\\d+)?$")
    private String precio;
    private String categoria;
    private Boolean disponibilidad;
}
