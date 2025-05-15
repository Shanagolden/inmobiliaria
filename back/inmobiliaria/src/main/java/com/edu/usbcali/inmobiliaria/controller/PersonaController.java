package com.edu.usbcali.inmobiliaria.controller;

import com.edu.usbcali.inmobiliaria.dto.PersonaDTO;
import com.edu.usbcali.inmobiliaria.model.Persona;
import com.edu.usbcali.inmobiliaria.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping("/todas")
    public List<Persona> buscarTodas() {
        return personaService.getAllPersonas();
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<PersonaDTO> buscarPorId(@PathVariable Integer id) {
        PersonaDTO personaDTO = personaService.getPersonaPorId(id);
        return new ResponseEntity<>(personaDTO, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<PersonaDTO> crearPersona(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO nuevaPersona = personaService.crearPersona(personaDTO);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PersonaDTO> actualizarPersona(@PathVariable Integer id, @RequestBody PersonaDTO personaDTO) {
        PersonaDTO personaActualizada = personaService.actualizarPersona(id, personaDTO);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Integer id) {
        personaService.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
