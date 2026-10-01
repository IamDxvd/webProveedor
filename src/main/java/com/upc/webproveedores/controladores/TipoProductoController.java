package com.upc.webproveedores.controladores;

import com.upc.webproveedores.entidades.TipoProducto;
import com.upc.webproveedores.servicios.TipoProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoProductoController {
    @Autowired
    private TipoProductoServicio tipoProductoServicio;

    @PostMapping("/tipos-producto")
    public TipoProducto insertar(@RequestBody TipoProducto tipoProducto){
        return tipoProductoServicio.insertar(tipoProducto);
    }
    @GetMapping("/tipos-productos")
    public List<TipoProducto> listar(){
        return tipoProductoServicio.listar();
    }
}
