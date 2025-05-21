package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.PersonaDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreatePersonaRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreatePersonaResponse;
import com.edu.usbcali.inmobiliaria.mapper.PersonaMapper;
import com.edu.usbcali.inmobiliaria.model.Persona;
import com.edu.usbcali.inmobiliaria.respository.PersonaRepository;
import com.edu.usbcali.inmobiliaria.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPersonas() {
        // Obtener todas las personas desde la base de datos
        return personaRepository.findAll();
    }

    @Override
    public PersonaDTO getPersonaPorId(Integer id) {
        // Obtener la persona por su ID y convertirla a DTO
        Persona persona = personaRepository.getReferenceById(id);
        return PersonaMapper.modelToDto(persona);
    }

    @Override
    public CreatePersonaResponse crearPersona(CreatePersonaRequest createPersonaRequest) throws Exception {
        // Validar que el request no sea nulo
        if (createPersonaRequest == null) {
            throw new Exception("La persona no puede ser nula.");
        }

        // Validar que el nombre no sea nulo ni vacío
        if (createPersonaRequest.getNombre() == null || createPersonaRequest.getNombre().isBlank()) {
            throw new Exception("El nombre no puede ser vacío.");
        }

        // Validar que el apellido no sea nulo ni vacío
        if (createPersonaRequest.getApellido() == null || createPersonaRequest.getApellido().isBlank()) {
            throw new Exception("El apellido no puede ser vacío.");
        }

        // Validar que el teléfono no sea nulo ni vacío
        if (createPersonaRequest.getTelefono() == null || createPersonaRequest.getTelefono().isBlank()) {
            throw new Exception("El teléfono no puede ser vacío.");
        }

        // Convertir de DTO a entidad (modelo)
        Persona persona = PersonaMapper.createRequestToModel(createPersonaRequest);

        // Guardar en base de datos
        persona = personaRepository.save(persona);

        // Convertir de modelo a respuesta DTO
        CreatePersonaResponse response = PersonaMapper.modelToCreateResponse(persona);
        return response;
    }

    @Override
    public PersonaDTO actualizarPersona(Integer id, PersonaDTO personaDTO) {
        // Obtener la entidad existente, actualizar sus datos, guardar y devolver DTO
        Persona personaExistente = personaRepository.getReferenceById(id);
        personaExistente.setNombre(personaDTO.getNombre());
        personaExistente.setApellido(personaDTO.getApellido());
        personaExistente.setEmail(personaDTO.getEmail());
        personaExistente.setTelefono(personaDTO.getTelefono());
        personaExistente.setDireccion(personaDTO.getDireccion());
        personaExistente.setCiudad(personaDTO.getCiudad());
        personaExistente.setCodigoPostal(personaDTO.getCodigoPostal());

        Persona personaActualizada = personaRepository.save(personaExistente);
        return PersonaMapper.modelToDto(personaActualizada);
    }

    @Override
    public void eliminarPersona(Integer id) {
        personaRepository.deleteById(id);
    }
}
