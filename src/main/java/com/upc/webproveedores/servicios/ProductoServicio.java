package com.upc.webproveedores.servicios;

import com.upc.webproveedores.entidades.Producto;
import com.upc.webproveedores.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto insertar(Producto producto){
        return productoRepositorio.save(producto);
    }
    public List<Producto> listar(){
        return productoRepositorio.findAll();
    }
    public List<Producto> listarProductosPorPrecioMayor(Double precio){
        return productoRepositorio.findByPrecioGreaterThanEqual(precio);
    }

    public List<Producto> findByTipoProducto_Id(Long idTipoProducto){
        return productoRepositorio.findByTipoProducto_Id(idTipoProducto);
    }


}
