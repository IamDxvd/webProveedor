package com.upc.webproveedores.repositorios;

import com.upc.webproveedores.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    Proveedor findByEmail(String email);
    //obtener a todos los proveedores que se registraron entre dos fechas dadas
    List<Proveedor> findByFechaInscripcionBetween(LocalDate inicio, LocalDate fim);
}

