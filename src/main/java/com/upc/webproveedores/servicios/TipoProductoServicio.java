package com.upc.webproveedores.servicios;

import com.upc.webproveedores.entidades.TipoProducto;
import com.upc.webproveedores.repositorios.TipoProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServicio {
    @Autowired
    private TipoProductoRepositorio tipoProductoRepositorio;

    public TipoProducto insertar(TipoProducto tipoProducto){
        return tipoProductoRepositorio.save(tipoProducto);
    }
    public List<TipoProducto> listar(){
        return tipoProductoRepositorio.findAll();
    }

}
