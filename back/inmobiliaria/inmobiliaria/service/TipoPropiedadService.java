package com.edu.usbcali.inmobiliaria.service;

import com.edu.usbcali.inmobiliaria.dto.TipoPropiedadDTO;
import com.edu.usbcali.inmobiliaria.dto.request.CreateTipoPropiedadRequest;
import com.edu.usbcali.inmobiliaria.dto.response.CreateTipoPropiedadResponse;
import com.edu.usbcali.inmobiliaria.model.TipoPropiedad;
import java.util.List;

public interface TipoPropiedadService {
    List<TipoPropiedad>getAllTipoPropiedad();
    TipoPropiedadDTO getTipoPropiedadPorId(Integer id);
    CreateTipoPropiedadResponse createTipoPropiedad(CreateTipoPropiedadRequest createTipoPropiedadRequest) throws Exception;
}
