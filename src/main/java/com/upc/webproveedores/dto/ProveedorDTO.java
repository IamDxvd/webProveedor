package com.upc.webproveedores.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {

    private Long  idProveedor;
    private String nombre;
    private String direccion;
    private LocalDate fechaInscripcion;
    private String telefono;
    private String email;
}
