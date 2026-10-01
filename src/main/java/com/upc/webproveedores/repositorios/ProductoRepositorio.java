package com.upc.webproveedores.repositorios;

import com.upc.webproveedores.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
    //listar los productos cuyo precio es mayor que un valor dado, query method
    List<Producto> findByPrecioGreaterThanEqual(Double precio);
    //listar todos los productos dado un tipo de producto query method
    List<Producto> findByTipoProducto_Id(Long id);
    //JPQL equivalente al anterior
    @Query("select p from Producto p where p.tipoProducto.id =: id")
    List<Producto> buscarPorIdTipoProducto(@Param("id") Long id);
    //JPQL Explicito equivalente al anterior
    @Query("select p from Producto p join p.tipoProducto t where t.id =: id")
    List<Producto> buscarPorIdTipoProductoExtendido(@Param("id") Long id);
}
