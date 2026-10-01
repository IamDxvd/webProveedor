package com.upc.webproveedores.servicios;

import com.upc.webproveedores.dto.ProveedorDTO;
import com.upc.webproveedores.entidades.Proveedor;
import com.upc.webproveedores.repositorios.ProveedorRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServicio {
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Proveedor insertar(ProveedorDTO proveedorDTO) {
        //convertir DTO a entidad
        Proveedor proveedor = modelMapper.map(proveedorDTO, ProveedorDTO.class);
        Proveedor proveedorGrabado = proveedorRepositorio.save(proveedor);
        return  modelMapper.map(proveedorGrabado, ProveedorDTO.class);
    }
    public List<ProveedorDTO> listar() {
        return proveedorRepositorio.findAll().stream().
                map(proveedor -> modelMapper.map(proveedor, ProveedorDTO.class)).
                collect(Collectors.toList());
    }
    public ProveedorDTO buscarPorId(Long id) {
        return proveedorRepositorio.findById(id).
                map(Proveedor proveedor -> modelMapper.map(proveedor, ProveedorDTO.class)).
                orElseThrow(() ->new RuntimeException("No existe el proveedor con el id: " + id));
    }
    @Transactional()
    public Proveedor editar(Proveedor proveedor) {
        if(proveedorRepositorio.existsById(proveedor.getIdProveedor()))
           return proveedorRepositorio.save(proveedor);
        return null;
    }
    @Transactional
    public void eliminar(Long id) {
        if(!proveedorRepositorio.existsById(id))
            throw new RuntimeException("No existe el proveedor con el id " + id);
        proveedorRepositorio.deleteById(id);
    }
    public Proveedor buscarProveedorPorEmail(String email) {
        return proveedorRepositorio.findByEmail(email);
    }
    public List<Proveedor> buscarPorFechaInscripcionBetween(LocalDate inicio, LocalDate fim) {
        return proveedorRepositorio.findByFechaInscripcionBetween(inicio, fim);
    }
}
