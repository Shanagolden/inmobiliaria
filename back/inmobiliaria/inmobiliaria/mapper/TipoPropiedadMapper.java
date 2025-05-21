package com.edu.usbcali.inmobiliaria.mapper;

import com.edu.usbcali.inmobiliaria.dto.TipoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateTipoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateTipoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.TipoPropiedad;

public class TipoPropiedadMapper {

    public static TipoPropiedadDTO modelToDto(TipoPropiedad tipoPropiedad){

        return TipoPropiedadDTO.builder()
                .nombre(tipoPropiedad.getNombre())
                .descripcion(tipoPropiedad.getDescripcion())
                .build();
    }

    public static TipoPropiedad dtoToModel(TipoPropiedadDTO tipoPropiedadDTO){
        return TipoPropiedad.builder()
                .nombre(tipoPropiedadDTO.getNombre())
                .descripcion(tipoPropiedadDTO.getDescripcion())
                .build();
    }
    public static TipoPropiedad createRequestToModel(CreateTipoPropiedadRequest createTipoPropiedadRequest){
        return TipoPropiedad.builder()
                .nombre(createTipoPropiedadRequest.getNombre())
                .descripcion(createTipoPropiedadRequest.getDescripcion())
                .build();
    }
    public static CreateTipoPropiedadResponse modelToCreateResponse(TipoPropiedad tipoPropiedad){
        return CreateTipoPropiedadResponse.builder()
                .id(tipoPropiedad.getIdTipoPropiedad())
                .nombre(tipoPropiedad.getNombre())
                .descripcion(tipoPropiedad.getDescripcion())
                .build();
    }
}
