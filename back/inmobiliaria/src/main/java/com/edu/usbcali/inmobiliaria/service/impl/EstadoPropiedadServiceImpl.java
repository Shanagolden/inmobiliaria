package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.EstadoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateEstadoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateEstadoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.mapper.EstadoPropiedadMapper;
import com.edu.usbcali.inmobiliaria.model.EstadoPropiedad;
import com.edu.usbcali.inmobiliaria.respository.EstadoPropiedadRepository;
import com.edu.usbcali.inmobiliaria.service.EstadoPropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoPropiedadServiceImpl implements EstadoPropiedadService {

    private final EstadoPropiedadRepository estadoPropiedadRepository;

    @Override
    public List<EstadoPropiedad> getAllEstadoPropiedad() {
        List<EstadoPropiedad> estadosPropiedad = estadoPropiedadRepository.findAll();
        return estadosPropiedad;
    }

    @Override
    public EstadoPropiedadDTO getEstadoPropiedadPorId(Integer id) {
        EstadoPropiedad estadoPropiedad = estadoPropiedadRepository.getReferenceById(id);
        EstadoPropiedadDTO estadoPropiedadDTO = EstadoPropiedadMapper.modelToDto(estadoPropiedad);
        return estadoPropiedadDTO;
    }

    @Override
    public CreateEstadoPropiedadResponse createEstadoPropiedad(CreateEstadoPropiedadRequest createEstadoPropiedadRequest) throws Exception {
        // Validar que el request no sea nulo
        if (createEstadoPropiedadRequest == null) {
            throw new Exception("El estado de propiedad no puede ser nulo.");
        }

        // Validar que el nombre no sea nulo ni vacío
        if (createEstadoPropiedadRequest.getNombre() == null || createEstadoPropiedadRequest.getNombre().isBlank()) {
            throw new Exception("El nombre no puede ser vacío.");
        }

        // Validar que la descripción no sea nula ni vacía
        if (createEstadoPropiedadRequest.getDescripcion() == null || createEstadoPropiedadRequest.getDescripcion().isBlank()) {
            throw new Exception("La descripción no puede ser vacía.");
        }

        // Convertir de DTO a entidad (modelo)
        EstadoPropiedad estadoPropiedad = EstadoPropiedadMapper.createRequestToModel(createEstadoPropiedadRequest);

        // Guardar en base de datos
        estadoPropiedad = estadoPropiedadRepository.save(estadoPropiedad);

        // Convertir de modelo a respuesta DTO
        CreateEstadoPropiedadResponse response = EstadoPropiedadMapper.modelToCreateResponse(estadoPropiedad);
        return response;
    }
}
