package com.edu.usbcali.inmobiliaria.controller;

import com.edu.usbcali.inmobiliaria.dto.EstadoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateEstadoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateEstadoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.EstadoPropiedad;
import com.edu.usbcali.inmobiliaria.service.EstadoPropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado-propiedad")
@RequiredArgsConstructor
public class EstadoPropiedadController {

    private final EstadoPropiedadService estadoPropiedadService;

    @GetMapping("/todos")
    public List<EstadoPropiedad> buscarTodos() {
        return estadoPropiedadService.getAllEstadoPropiedad();
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<EstadoPropiedadDTO> buscarPorId(@PathVariable Integer id) {
        EstadoPropiedadDTO estadoPropiedadDTO = estadoPropiedadService.getEstadoPropiedadPorId(id);
        return new ResponseEntity<>(estadoPropiedadDTO, HttpStatus.OK);
    }

    @PostMapping("/guardar-nuevo")
    public ResponseEntity<CreateEstadoPropiedadResponse> guardarNuevo(@RequestBody CreateEstadoPropiedadRequest createEstadoPropiedadRequest) throws Exception {
        CreateEstadoPropiedadResponse response = estadoPropiedadService.createEstadoPropiedad(createEstadoPropiedadRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
