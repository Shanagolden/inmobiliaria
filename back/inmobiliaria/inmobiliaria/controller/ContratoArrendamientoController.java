package com.edu.usbcali.inmobiliaria.controller;

import com.edu.usbcali.inmobiliaria.dto.request.CreateContratoArrendamientoRequest;
import com.edu.usbcali.inmobiliaria.dto.response.ContratoArrendamientoResponse;
import com.edu.usbcali.inmobiliaria.model.ContratoArrendamiento;
import com.edu.usbcali.inmobiliaria.service.ContratoArrendamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato-arrendamiento")
@RequiredArgsConstructor
public class ContratoArrendamientoController {

    private final ContratoArrendamientoService contratoArrendamientoService;

    @GetMapping("/todos")
    public List<ContratoArrendamiento> buscarTodos() {
        return contratoArrendamientoService.getAllContratosArrendamiento();
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<ContratoArrendamientoResponse> buscarPorId(@PathVariable Integer id) {
        ContratoArrendamientoResponse contratoResponse = contratoArrendamientoService.getContratoArrendamientoPorId(id);
        return new ResponseEntity<>(contratoResponse, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ContratoArrendamientoResponse> crearContratoArrendamiento(@RequestBody CreateContratoArrendamientoRequest createContratoArrendamientoRequest) throws Exception {
        ContratoArrendamientoResponse nuevoContrato = contratoArrendamientoService.crearContratoArrendamiento(createContratoArrendamientoRequest);
        return new ResponseEntity<>(nuevoContrato, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ContratoArrendamientoResponse> actualizarContratoArrendamiento(@PathVariable Integer id, @RequestBody CreateContratoArrendamientoRequest createContratoArrendamientoRequest) throws Exception {
        ContratoArrendamientoResponse contratoActualizado = contratoArrendamientoService.actualizarContratoArrendamiento(id, createContratoArrendamientoRequest);
        return new ResponseEntity<>(contratoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarContratoArrendamiento(@PathVariable Integer id) {
        contratoArrendamientoService.eliminarContratoArrendamiento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
