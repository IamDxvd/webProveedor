package com.upc.webproveedores.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  idProveedor;
    @Column(length = 50, nullable = false)
    private String nombre;
    private String direccion;
    private LocalDate fechaInscripcion;
    private String telefono;
    @Column(unique = true, nullable = false)
    private String email;
}
