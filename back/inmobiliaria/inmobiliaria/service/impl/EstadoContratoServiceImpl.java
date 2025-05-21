package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.EstadoContratoDTO;
import com.edu.usbcali.inmobiliaria.mapper.EstadoContratoMapper;
import com.edu.usbcali.inmobiliaria.model.EstadoContrato;
import com.edu.usbcali.inmobiliaria.respository.EstadoContratoRepository;
import com.edu.usbcali.inmobiliaria.service.EstadoContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoContratoServiceImpl implements EstadoContratoService {

    private final EstadoContratoRepository estadoContratoRepository;

    @Override
    public List<EstadoContrato> getAllEstadoContrato() {
        return estadoContratoRepository.findAll();
    }

    @Override
    public EstadoContratoDTO getEstadoContratoPorId(Integer id) {
        EstadoContrato estadoContrato = estadoContratoRepository.getReferenceById(id);
        return EstadoContratoMapper.modelToDto(estadoContrato);
    }

    @Override
    public EstadoContratoDTO crearEstadoContrato(EstadoContratoDTO estadoContratoDTO) {
        EstadoContrato estadoContrato = EstadoContratoMapper.dtoToModel(estadoContratoDTO);
        EstadoContrato guardado = estadoContratoRepository.save(estadoContrato);
        return EstadoContratoMapper.modelToDto(guardado);
    }

    @Override
    public EstadoContratoDTO actualizarEstadoContrato(Integer id, EstadoContratoDTO estadoContratoDTO) {
        EstadoContrato existente = estadoContratoRepository.getReferenceById(id);
        existente.setNombre(estadoContratoDTO.getNombre());
        existente.setDescripcion(estadoContratoDTO.getDescripcion());
        EstadoContrato actualizado = estadoContratoRepository.save(existente);
        return EstadoContratoMapper.modelToDto(actualizado);
    }

    @Override
    public void eliminarEstadoContrato(Integer id) {
        estadoContratoRepository.deleteById(id);
    }
}
