package com.edu.usbcali.inmobiliaria.service.impl;

import com.edu.usbcali.inmobiliaria.dto.PersonaDTO;
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
    public PersonaDTO crearPersona(PersonaDTO personaDTO) {
        // Convertir el DTO a entidad, guardar y devolver como DTO
        Persona persona = PersonaMapper.dtoToModel(personaDTO);
        Persona personaGuardada = personaRepository.save(persona);
        return PersonaMapper.modelToDto(personaGuardada);
    }

    @Override
    public PersonaDTO actualizarPersona(Integer id, PersonaDTO personaDTO) {
        // Obtener la entidad existente, actualizar sus datos, guardar y devolver DTO
        Persona personaExistente = personaRepository.getReferenceById(id);
        personaExistente.setNombre(personaDTO.getNombre());
        personaExistente.setApellido(personaDTO.getApellido());
        personaExistente.setEmail(personaDTO.getEmail());
        // Agrega otros campos según tu modelo

        Persona personaActualizada = personaRepository.save(personaExistente);
        return PersonaMapper.modelToDto(personaActualizada);
    }

    @Override
    public void eliminarPersona(Integer id) {
        personaRepository.deleteById(id);
    }
}
