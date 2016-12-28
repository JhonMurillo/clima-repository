/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.cityPerson.facade;

import com.app.weather.interfaces.cityPerson.dto.CityPersonDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CityPersonFacade {

    CityPersonDTO save(CityPersonDTO cityPersonDTO);

    List<CityPersonDTO> findAll();

    List<CityPersonDTO> findByIdPerson(Long idPerson);

    List<CityPersonDTO> findByIdCity(Long idCity);

    CityPersonDTO findById(Long id);

    CityPersonDTO findByIdCityAndIdPerson(Long idCity, Long idPerson);

    void delete(Long id);

}
