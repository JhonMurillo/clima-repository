/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.city.facade;

import com.app.weather.interfaces.city.dto.CityDTO;
import com.app.weather.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CityFacade {

    ResponseUtil save(CityDTO cityDTO);

    CityDTO findById(Long id);

    List<CityDTO> findAll();

    List<CityDTO> findByName(String name);

    List<CityDTO> findByIdState(Long idState);

    CityDTO findByCode(String code);

    CityDTO findByLatitudeAndLongitude(String latitude, String longitude);
}
