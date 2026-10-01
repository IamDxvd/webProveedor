package com.upc.webproveedores.controladores;

import com.upc.webproveedores.dto.ProveedorDTO;
import com.upc.webproveedores.entidades.Proveedor;
import com.upc.webproveedores.servicios.ProveedorServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api") //prefijo
@Slf4j
public class ProveedorControl {
    @Autowired
    private ProveedorServicio proveedorServicio;
    @PostMapping("/proveedor") //EndPoint
    public ProveedorDTO insertar(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorServicio.insertar(proveedorDTO);
    }
    @GetMapping("/proveedores")
    public List<ProveedorDTO> listar() {
        log.debug("Iniciando lista de proveedores");
        return proveedorServicio.listar();
    }
    @GetMapping("/proveedor/{id}")
    public ProveedorDTO buscarPorId(@PathVariable Long id) {
        log.info("Iniciando buscar proveedor {}", id);
        return proveedorServicio.buscarPorId(id);
    }
    @PutMapping("/proveedor")
    public Proveedor editar(@RequestBody Proveedor proveedor) {
        return proveedorServicio.editar(proveedor);
    }
    @DeleteMapping("/proveedor/{id}")
    public void eliminar(@PathVariable Long id) {
        proveedorServicio.eliminar(id);
    }

    @GetMapping("/proveedor/email/{email}")
    public Proveedor buscarProveedorPorEmail(@PathVariable String email) {
        return proveedorServicio.buscarProveedorPorEmail(email);
    }

    @GetMapping("/proveedores/{inicio}/{fin}")
    public List<Proveedor> buscarPorFechaInscripcionBetween(@PathVariable LocalDate inicio, @PathVariable LocalDate fin) {
        return proveedorServicio.buscarPorFechaInscripcionBetween(inicio, fin);
    }
}
