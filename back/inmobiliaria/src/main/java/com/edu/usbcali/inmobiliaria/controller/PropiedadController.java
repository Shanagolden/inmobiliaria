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
    public ResponseEntity<List<Propiedad>> buscarTodas() {
        try {
            List<Propiedad> propiedades = propiedadService.getAllPropiedades();
            return new ResponseEntity<>(propiedades, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            PropiedadResponse propiedadResponse = propiedadService.getPropiedadPorId(id);
            return new ResponseEntity<>(propiedadResponse, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearPropiedad(@RequestBody CreatePropiedadRequest createPropiedadRequest) {
        try {
            PropiedadResponse nuevaPropiedad = propiedadService.createPropiedad(createPropiedadRequest);
            return new ResponseEntity<>(nuevaPropiedad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarPropiedad(@PathVariable Integer id, @RequestBody CreatePropiedadRequest createPropiedadRequest) {
        try {
            PropiedadResponse propiedadActualizada = propiedadService.actualizarPropiedad(id, createPropiedadRequest);
            return new ResponseEntity<>(propiedadActualizada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPropiedad(@PathVariable Integer id) {
        try {
            propiedadService.eliminarPropiedad(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
