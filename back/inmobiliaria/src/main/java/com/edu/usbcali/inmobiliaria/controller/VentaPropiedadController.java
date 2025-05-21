package com.edu.usbcali.inmobiliaria.controller;

import com.edu.usbcali.inmobiliaria.dto.request.CreateVentaPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.VentaPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.VentaPropiedad;
import com.edu.usbcali.inmobiliaria.service.VentaPropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta-propiedad")
@RequiredArgsConstructor
public class VentaPropiedadController {

    private final VentaPropiedadService ventaPropiedadService;

    @GetMapping("/todas")
    public List<VentaPropiedad> buscarTodas() {
        return ventaPropiedadService.getAllVentasPropiedades();
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<VentaPropiedadResponse> buscarPorId(@PathVariable Integer id) {
        VentaPropiedadResponse ventaPropiedadResponse = ventaPropiedadService.getVentaPropiedadPorId(id);
        return new ResponseEntity<>(ventaPropiedadResponse, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<VentaPropiedadResponse> crearVentaPropiedad(@RequestBody CreateVentaPropiedadRequest createVentaPropiedadRequest) throws Exception {
        VentaPropiedadResponse nuevaVenta = ventaPropiedadService.crearVentaPropiedad(createVentaPropiedadRequest);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VentaPropiedadResponse> actualizarVentaPropiedad(@PathVariable Integer id, @RequestBody CreateVentaPropiedadRequest createVentaPropiedadRequest) throws Exception {
        VentaPropiedadResponse ventaActualizada = ventaPropiedadService.actualizarVentaPropiedad(id, createVentaPropiedadRequest);
        return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVentaPropiedad(@PathVariable Integer id) {
        ventaPropiedadService.eliminarVentaPropiedad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
