package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.request.CreateContratoArrendamientoRequest;
import com.edu.usbcali.inmobiliaria.dto.response.ContratoArrendamientoResponse;
import com.edu.usbcali.inmobiliaria.model.ContratoArrendamiento;

import java.util.List;

public interface ContratoArrendamientoService {
    List<ContratoArrendamiento> getAllContratosArrendamiento();
    ContratoArrendamientoResponse getContratoArrendamientoPorId(Integer id);
    ContratoArrendamientoResponse crearContratoArrendamiento(CreateContratoArrendamientoRequest createContratoArrendamientoRequest) throws Exception;
    ContratoArrendamientoResponse actualizarContratoArrendamiento(Integer id, CreateContratoArrendamientoRequest createContratoArrendamientoRequest) throws Exception;
    void eliminarContratoArrendamiento(Integer id);
}
