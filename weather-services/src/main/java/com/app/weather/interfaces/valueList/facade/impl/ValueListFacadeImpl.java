/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.valueList.facade.impl;

import com.app.weather.domains.valueList.ValueList;
import com.app.weather.interfaces.valueList.dto.ValueListDTO;
import com.app.weather.interfaces.valueList.facade.*;
import com.app.weather.interfaces.valueList.service.ValueListService;
import com.app.weather.utils.ConstanteUtil;
import com.app.weather.utils.ObjectMapperUtil;
import com.app.weather.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DESARROLLO
 */
@Transactional
@Component("valueListFacade")
public class ValueListFacadeImpl implements ValueListFacade {

    @Autowired
    ValueListService valueListService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    public final static org.slf4j.Logger LOG = LoggerFactory.getLogger(ValueListFacadeImpl.class);

    @Override
    public ValueListDTO findById(Long id) {
        ValueList valueList = valueListService.findById(id);
        if (valueList == null) {
            return null;
        }
        ValueListDTO valueListDTO = objectMapper.convertValue(valueList, ValueListDTO.class);
        return valueListDTO;
    }

    @Override
    public ValueListDTO findByCategoryAndValue(String category, String value) {
        ValueList valueList = valueListService.findByCategoryAndValue(category, value);
        if (valueList == null) {
            return null;
        }
        ValueListDTO valueListDTO = objectMapper.convertValue(valueList, ValueListDTO.class);
        return valueListDTO;
    }

//    @Override
//    public List<ValueListDTO> findAll() {
//        try {
//            List<ValueList> listaValueList = (List<ValueList>) valueListService.findAll();
//            if (listaValueList == null) {
//                return null;
//            }
//            return convertListToDTO(listaValueList);
//        } catch (Exception ex) {
//            LOG.warn("Error : " + ex);
//        }
//        return new ArrayList<>();
//    }

    @Override
    public ResponseUtil save(ValueListDTO valueListDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            ValueList valueList = objectMapper.convertValue(valueListDTO, ValueList.class);
            valueListService.save(valueList);
            valueListDTO = objectMapper.convertValue(valueList, ValueListDTO.class);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(valueListDTO);
            return responseUtil;
        } catch (IllegalArgumentException e) {
            LOG.warn("Error : " + e);
        } catch (DataIntegrityViolationException da) {
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            responseUtil.setMessage("Ya existe un funcionario con este usuario.");
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }

    @Override
    public List<ValueListDTO> findByCategory(String category) {
        try {
            List<ValueList> listaValueList = (List<ValueList>) valueListService.findByCategory(category);
            if (listaValueList == null) {
                return null;
            }
            return convertListToDTO(listaValueList);
        } catch (Exception ex) {
            LOG.warn("Error : " + ex);
        }
        return new ArrayList<>();
    }

    public List<ValueListDTO> convertListToDTO(List<ValueList> listValueList) {
        List<ValueListDTO> listaValueListDTO = new ArrayList<>();

        listValueList.stream().map((valueList) -> {
            ValueListDTO valueListDTO = new ValueListDTO();
            valueListDTO.setId(valueList.id());
            valueListDTO.setCategory(valueList.category());
            valueListDTO.setDescription(valueList.description());
            valueListDTO.setValue(valueList.value());
            return valueListDTO;
        }).forEachOrdered((valueListDTO) -> {
            listaValueListDTO.add(valueListDTO);
        });
        return listaValueListDTO;
    }

}
