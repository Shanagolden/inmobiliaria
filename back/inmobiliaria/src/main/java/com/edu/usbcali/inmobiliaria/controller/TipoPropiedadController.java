package com.edu.usbcali.inmobiliaria.controller;

import com.edu.usbcali.inmobiliaria.dto.TipoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateTipoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateTipoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.TipoPropiedad;
import com.edu.usbcali.inmobiliaria.respository.TipoPropiedadRepository;
import com.edu.usbcali.inmobiliaria.service.TipoPropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo-propiedad")
@RequiredArgsConstructor
public class TipoPropiedadController {
    //inyeccion de dependencias del servicio en el controlador
    private final TipoPropiedadService tipoPropiedadService;

    @GetMapping("/todos")
    public List<TipoPropiedad> buscarTodos(){
        return tipoPropiedadService.getAllTipoPropiedad();
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<TipoPropiedadDTO> buscarPorId(@PathVariable Integer id) {
        TipoPropiedadDTO tipoPropiedadDTO = tipoPropiedadService.getTipoPropiedadPorId(id);

        return new ResponseEntity<>(tipoPropiedadDTO, HttpStatus.OK);
    }

    //Metodo para guardar un nuevo tipo de propiedad y sera de tipo POST
    @PostMapping("/guardar-nuevo")
    public ResponseEntity<CreateTipoPropiedadResponse> guardarNuevo(@RequestBody CreateTipoPropiedadRequest createTipoPropiedadRequest) throws Exception{
        CreateTipoPropiedadResponse createTipoPropiedadResponse = tipoPropiedadService.createTipoPropiedad(createTipoPropiedadRequest);
        return new ResponseEntity<>(createTipoPropiedadResponse, HttpStatus.CREATED);
    }
}
