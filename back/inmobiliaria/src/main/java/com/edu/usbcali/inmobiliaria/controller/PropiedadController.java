package com.edu.usbcali.inmobiliaria.controller;

import com.edu.usbcali.inmobiliaria.dto.request.CreatePropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.PropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.Propiedad;
import com.edu.usbcali.inmobiliaria.service.PropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propiedad")
@RequiredArgsConstructor
public class PropiedadController {

    private final PropiedadService propiedadService;

    @GetMapping("/todas")
    public List<Propiedad> buscarTodas() {
        return propiedadService.getAllPropiedades();
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<PropiedadResponse> buscarPorId(@PathVariable Integer id) {
        PropiedadResponse propiedadResponse = propiedadService.getPropiedadPorId(id);
        return new ResponseEntity<>(propiedadResponse, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<PropiedadResponse> crearPropiedad(@RequestBody CreatePropiedadRequest createPropiedadRequest) throws Exception {
        PropiedadResponse nuevaPropiedad = propiedadService.crearPropiedad(createPropiedadRequest);
        return new ResponseEntity<>(nuevaPropiedad, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PropiedadResponse> actualizarPropiedad(@PathVariable Integer id, @RequestBody CreatePropiedadRequest createPropiedadRequest) throws Exception {
        PropiedadResponse propiedadActualizada = propiedadService.actualizarPropiedad(id, createPropiedadRequest);
        return new ResponseEntity<>(propiedadActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPropiedad(@PathVariable Integer id) {
        propiedadService.eliminarPropiedad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
