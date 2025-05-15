package com.edu.usbcali.inmobiliaria.controller;

import com.edu.usbcali.inmobiliaria.dto.EstadoContratoDTO;
import com.edu.usbcali.inmobiliaria.model.EstadoContrato;
import com.edu.usbcali.inmobiliaria.service.EstadoContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado-contrato")
@RequiredArgsConstructor
public class EstadoContratoController {

    private final EstadoContratoService estadoContratoService;

    @GetMapping("/todos")
    public List<EstadoContrato> buscarTodos() {
        return estadoContratoService.getAllEstadoContrato();
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<EstadoContratoDTO> buscarPorId(@PathVariable Integer id) {
        EstadoContratoDTO estadoContratoDTO = estadoContratoService.getEstadoContratoPorId(id);
        return new ResponseEntity<>(estadoContratoDTO, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<EstadoContratoDTO> crearEstadoContrato(@RequestBody EstadoContratoDTO estadoContratoDTO) {
        EstadoContratoDTO nuevoEstado = estadoContratoService.crearEstadoContrato(estadoContratoDTO);
        return new ResponseEntity<>(nuevoEstado, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EstadoContratoDTO> actualizarEstadoContrato(@PathVariable Integer id, @RequestBody EstadoContratoDTO estadoContratoDTO) {
        EstadoContratoDTO actualizado = estadoContratoService.actualizarEstadoContrato(id, estadoContratoDTO);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEstadoContrato(@PathVariable Integer id) {
        estadoContratoService.eliminarEstadoContrato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
