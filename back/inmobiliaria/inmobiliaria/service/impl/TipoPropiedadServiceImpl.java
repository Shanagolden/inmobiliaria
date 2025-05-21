package com.edu.usbcali.inmobiliaria.service.impl;
import com.edu.usbcali.inmobiliaria.dto.TipoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateTipoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateTipoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.mapper.TipoPropiedadMapper;
import com.edu.usbcali.inmobiliaria.model.TipoPropiedad;
import com.edu.usbcali.inmobiliaria.respository.TipoPropiedadRepository;
import com.edu.usbcali.inmobiliaria.service.TipoPropiedadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TipoPropiedadServiceImpl implements TipoPropiedadService {

    private final TipoPropiedadRepository tipoPropiedadRepository;

    @Override
    public List<TipoPropiedad> getAllTipoPropiedad() {
        //aqui vamos a hacer la implementacion de este

        //Declare e inicializo una lista de tipos de propiedades
        //en la inicializacion utilizo el metodo findAll de repository
        //para ir a la base de datos y traer los tipos de propiedades :D
        List<TipoPropiedad> tiposPropiedad = tipoPropiedadRepository.findAll();
        //Retorno los tipos de propiedad consultados en la linea anterior
        return tiposPropiedad;
    }

    @Override
    public TipoPropiedadDTO getTipoPropiedadPorId(Integer id) {
        TipoPropiedad tipoPropiedad = tipoPropiedadRepository.getReferenceById(id);
        TipoPropiedadDTO tipoPropiedadDTO = TipoPropiedadMapper.modelToDto(tipoPropiedad);
        return tipoPropiedadDTO;
    }

    @Override
    public CreateTipoPropiedadResponse createTipoPropiedad(CreateTipoPropiedadRequest createTipoPropiedadRequest) throws Exception{
        //poner validaciones logicas respecto al DTO del Tipo de Propiedad

        //validar que el tipo de propiedad no sea nulo
        if(createTipoPropiedadRequest == null){
            throw new Exception("El tipo propiedad no puede ser nulo.");
        }
        //validar que el nombre no sea nulo
        if(createTipoPropiedadRequest.getNombre() == null || createTipoPropiedadRequest.getNombre(). isBlank() == true){
            throw new Exception("En Nombre no  puede ser vacio.");
        }
        //validar que la descripcion del tipo de propiedad a agregar no sea nula ni vacia
        if(createTipoPropiedadRequest.getDescripcion() == null || createTipoPropiedadRequest.getDescripcion().isBlank() == true){
            throw new Exception("La descripcion no puede ser vacia.");
        }

        //convertir de DTO a Model
        TipoPropiedad tipoPropiedad = TipoPropiedadMapper.createRequestToModel(createTipoPropiedadRequest);

        //Persistir el modelo en base de datos
        tipoPropiedad = tipoPropiedadRepository.save(tipoPropiedad);

        CreateTipoPropiedadResponse createTipoPropiedadResponse = TipoPropiedadMapper.modelToCreateResponse(tipoPropiedad);
        return createTipoPropiedadResponse;
    }

}
