package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.EstadoContratoDTO;
import com.edu.usbcali.inmobiliaria.model.EstadoContrato;

import java.util.List;

public interface EstadoContratoService {
    List<EstadoContrato> getAllEstadoContrato();

    EstadoContratoDTO getEstadoContratoPorId(Integer id);

    EstadoContratoDTO crearEstadoContrato(EstadoContratoDTO estadoContratoDTO);

    EstadoContratoDTO actualizarEstadoContrato(Integer id, EstadoContratoDTO estadoContratoDTO);

    void eliminarEstadoContrato(Integer id);
}
