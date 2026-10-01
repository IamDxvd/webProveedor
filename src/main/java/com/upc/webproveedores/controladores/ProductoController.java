package com.upc.webproveedores.controladores;

import com.upc.webproveedores.entidades.Producto;
import com.upc.webproveedores.repositorios.ProductoRepositorio;
import com.upc.webproveedores.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private ProductoServicio productoServicio;
    @PostMapping("/producto")
    public Producto insertar(@RequestBody Producto producto){
        return productoServicio.insertar(producto);
    }
    @GetMapping("/productos")
    public List<Producto> listar(){
        return productoServicio.listar();
    }
    @GetMapping("/productos-precio/{precio}")
    public List<Producto> listarProductosPorPrecioMayor(@PathVariable Double precio){
        return productoServicio.listarProductosPorPrecioMayor(precio);
    }
    @GetMapping("/productos_1/{idTipoProducto}")
    public List<Producto> findByTipoProducto_Id(@PathVariable Long idTipoProducto){
        return productoServicio.findByTipoProducto_Id(idTipoProducto);
    }

}
