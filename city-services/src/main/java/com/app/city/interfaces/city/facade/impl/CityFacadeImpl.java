/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.interfaces.city.facade.impl;

import com.app.city.domains.city.City;
import com.app.city.interfaces.city.dto.CityDTO;
import com.app.city.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.app.city.interfaces.city.service.CityService;
import org.springframework.stereotype.Component;
import com.app.city.interfaces.city.facade.CityFacade;
import com.app.city.interfaces.valueList.service.ValueListService;
import com.app.city.utils.ConstanteUtil;
import com.app.city.utils.ResponseUtil;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import com.app.city.jms.messages.JmsCityService;

/**
 *
 * @author DESARROLLO
 */
@Component("cityFacade")
public class CityFacadeImpl implements CityFacade {
    
    @Autowired
    CityService cityService;
    
    @Autowired
    ValueListService valueListService;
    
    @Autowired
    JmsCityService jmsCityService;
    
    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();
    
    public final static org.slf4j.Logger LOG = LoggerFactory.getLogger(CityFacadeImpl.class);
    
    @Override
    @Transactional
    public ResponseUtil save(CityDTO cityDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            City city = objectMapper.convertValue(cityDTO, City.class);
            cityService.save(city);
            cityDTO = objectMapper.convertValue(city, CityDTO.class);
            jmsCityService.sendCity(cityDTO);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(cityDTO);
            return responseUtil;
        } catch (IllegalArgumentException e) {
            LOG.warn("Error : " + e);
        } catch (DataIntegrityViolationException da) {
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            responseUtil.setMessage("exist code.");
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }
    
    @Override
    public CityDTO findById(Long id) {
        City city = cityService.findById(id);
        if (city == null) {
            return null;
        }
        CityDTO cityDTO = objectMapper.convertValue(city, CityDTO.class);
        return cityDTO;
    }
    
    @Override
    public List<CityDTO> findAll() {
        try {
            List<City> listCity = (List<City>) cityService.findAll();
            if (listCity == null) {
                return null;
            }
            return convertListToDTO(listCity);
        } catch (Exception ex) {
            LOG.warn("Error : " + ex);
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<CityDTO> findByName(String name) {
        try {
            List<City> listCity = (List<City>) cityService.findByName(name);
            if (listCity == null) {
                return null;
            }
            return convertListToDTO(listCity);
        } catch (Exception ex) {
            LOG.warn("Error : " + ex);
        }
        return new ArrayList<>();
    }
    
    @Override
    public List<CityDTO> findByIdState(Long idState) {
        try {
            List<City> listCity = (List<City>) cityService.findByIdState(idState);
            if (listCity == null) {
                return null;
            }
            return convertListToDTO(listCity);
        } catch (Exception ex) {
            LOG.warn("Error : " + ex);
        }
        return new ArrayList<>();
    }
    
    @Override
    public CityDTO findByCode(String code) {
        City city = cityService.findByCode(code);
        if (city == null) {
            return null;
        }
        CityDTO cityDTO = objectMapper.convertValue(city, CityDTO.class);
        return cityDTO;
    }
    
    @Override
    public CityDTO findByLatitudeAndLongitude(String latitude, String longitude) {
        City city = cityService.findByLatitudeAndLongitude(latitude, longitude);
        if (city == null) {
            return null;
        }
        CityDTO cityDTO = objectMapper.convertValue(city, CityDTO.class);
        return cityDTO;
    }
    
    @Override
    public List<CityDTO> findByNameLike(String name) {
        try {
            List<City> listCity = (List<City>) cityService.findByNameLike(name);
            if (listCity == null) {
                return null;
            }
            return convertListToDTO(listCity);
        } catch (Exception ex) {
            LOG.warn("Error : " + ex);
        }
        return new ArrayList<>();
    }
    
    public List<CityDTO> convertListToDTO(List<City> listCity) {
        List<CityDTO> listaCityDTO = new ArrayList<>();
        
        listCity.stream().map((city) -> {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setId(city.id());
            cityDTO.setCode(city.code());
            cityDTO.setName(city.name());
            cityDTO.setLatitude(city.latitude());
            cityDTO.setLongitude(city.longitude());
            cityDTO.setIdState(city.idState());
            cityDTO.setStateName(city.idState() != null ? valueListService.findById(city.idState()).description() : null);
            return cityDTO;
        }).forEachOrdered((cityDTO) -> {
            listaCityDTO.add(cityDTO);
        });
        return listaCityDTO;
    }
    
}
