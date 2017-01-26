/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.cityPerson.facade.impl;

import com.app.app.domains.cityPerson.CityPerson;
import com.app.app.interfaces.cityPerson.dto.CityPersonDTO;
import com.app.app.interfaces.cityPerson.facade.CityPersonFacade;
import com.app.app.interfaces.cityPerson.service.CityPersonService;
import com.app.app.utils.MethodsUtil;
import com.app.app.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("CityPersonFacade")
@Service
public class CityPersonFacadeImpl implements CityPersonFacade {

    @Autowired
    CityPersonService cityPersonService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public CityPersonDTO save(CityPersonDTO cityPersonDTO) {
        CityPerson cityPerson = objectMapper.convertValue(cityPersonDTO, CityPerson.class);

//        CityPerson cityPerson = MethodsUtil.convertObject(cityPCersonDTO);
        return objectMapper.convertValue(cityPersonService.save(cityPerson), CityPersonDTO.class);
    }

    @Override
    public List<CityPersonDTO> findAll() {
        return convertListToDTO(cityPersonService.findAll());
    }

    @Override
    public List<CityPersonDTO> findByIdPerson(Long idPerson) {
        return convertListToDTO(cityPersonService.findByIdPerson(idPerson));
    }

    @Override
    public List<CityPersonDTO> findByIdCity(Long idCity) {
        return convertListToDTO(cityPersonService.findByIdCity(idCity));
    }

    @Override
    public CityPersonDTO findById(Long id) {
        return objectMapper.convertValue(cityPersonService.findById(id), CityPersonDTO.class);
    }

    @Override
    public CityPersonDTO findByIdCityAndIdPerson(Long idCity, Long idPerson) {
        return objectMapper.convertValue(cityPersonService.findByIdCityAndIdPerson(idCity, idPerson), CityPersonDTO.class);
    }

    public List<CityPersonDTO> convertListToDTO(List<CityPerson> listCity) {
        List<CityPersonDTO> listaCityDTO = new ArrayList<>();

        listCity.stream().map((city) -> {
            CityPersonDTO cityDTO = new CityPersonDTO();
            cityDTO.setId(city.id());
            cityDTO.setIdCity(city.idCity());
            cityDTO.setIdPerson(city.idPerson());
            return cityDTO;
        }).forEachOrdered((cityDTO) -> {
            listaCityDTO.add(cityDTO);
        });
        return listaCityDTO;
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
