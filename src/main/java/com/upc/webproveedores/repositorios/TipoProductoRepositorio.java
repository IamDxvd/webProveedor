package com.upc.webproveedores.repositorios;

import com.upc.webproveedores.entidades.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepositorio extends JpaRepository<TipoProducto,Long> {
}
