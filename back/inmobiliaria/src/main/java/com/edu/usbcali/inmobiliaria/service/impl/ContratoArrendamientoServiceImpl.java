package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.request.CreateContratoArrendamientoRequest;
import com.edu.usbcali.inmobiliaria.dto.response.ContratoArrendamientoResponse;
import com.edu.usbcali.inmobiliaria.model.ContratoArrendamiento;
import com.edu.usbcali.inmobiliaria.respository.ContratoArrendamientoRepository;
import com.edu.usbcali.inmobiliaria.service.ContratoArrendamientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoArrendamientoServiceImpl implements ContratoArrendamientoService {

    private final ContratoArrendamientoRepository contratoArrendamientoRepository;

    @Override
    public List<ContratoArrendamiento> getAllContratosArrendamiento() {
        // Implementación vacía
        return null;
    }

    @Override
    public ContratoArrendamientoResponse getContratoArrendamientoPorId(Integer id) {
        // Implementación vacía
        return null;
    }

    @Override
    public ContratoArrendamientoResponse crearContratoArrendamiento(CreateContratoArrendamientoRequest createContratoArrendamientoRequest) throws Exception {
        // Implementación vacía
        return null;
    }

    @Override
    public ContratoArrendamientoResponse actualizarContratoArrendamiento(Integer id, CreateContratoArrendamientoRequest createContratoArrendamientoRequest) throws Exception {
        // Implementación vacía
        return null;
    }

    @Override
    public void eliminarContratoArrendamiento(Integer id) {
        // Implementación vacía
    }
}
