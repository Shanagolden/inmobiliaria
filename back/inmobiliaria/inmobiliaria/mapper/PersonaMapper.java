package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.PersonaDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreatePersonaRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreatePersonaResponse;
import com.edu.usbcali.inmobiliaria.model.Persona;

public class PersonaMapper {
    public static PersonaDTO modelToDto(Persona persona){
        return PersonaDTO.builder()
                .idPerson(persona.getIdPerson())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .telefono(persona.getTelefono())
                .email(persona.getEmail())
                .direccion(persona.getDireccion())
                .ciudad(persona.getCiudad())
                .codigoPostal(persona.getCodigoPostal())
                .build();
    }

    public static Persona dtoToModel(PersonaDTO personaDTO){
        return Persona.builder()
                .idPerson(personaDTO.getIdPerson())
                .nombre(personaDTO.getNombre())
                .apellido(personaDTO.getApellido())
                .telefono(personaDTO.getTelefono())
                .email(personaDTO.getEmail())
                .direccion(personaDTO.getDireccion())
                .ciudad(personaDTO.getCiudad())
                .codigoPostal(personaDTO.getCodigoPostal())
                .build();
    }

    public static Persona createRequestToModel(CreatePersonaRequest request) {
        return Persona.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .telefono(request.getTelefono())
                .email(request.getEmail())
                .direccion(request.getDireccion())
                .ciudad(request.getCiudad())
                .codigoPostal(request.getCodigoPostal())
                .build();
    }

    public static CreatePersonaResponse modelToCreateResponse(Persona persona) {
        return CreatePersonaResponse.builder()
                .idPerson(persona.getIdPerson())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .telefono(persona.getTelefono())
                .email(persona.getEmail())
                .direccion(persona.getDireccion())
                .ciudad(persona.getCiudad())
                .codigoPostal(persona.getCodigoPostal())
                .build();
    }
}
