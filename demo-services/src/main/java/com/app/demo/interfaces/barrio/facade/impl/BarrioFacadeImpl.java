/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.facade.impl;

import com.app.app.utils.ConstanteUtil;
import com.app.demo.domains.barrio.Barrio;
import com.app.demo.interfaces.barrio.dto.BarrioAllDTO;
import com.app.demo.interfaces.barrio.dto.BarrioDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.app.demo.interfaces.barrio.facade.BarrioFacade;
import com.app.demo.interfaces.barrio.service.BarrioService;
import com.app.demo.utils.ObjectMapperUtil;
import com.app.demo.utils.ResponseUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.PropertyAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO
 */
@Component("barrioFacade")
@Transactional
public class BarrioFacadeImpl implements BarrioFacade {

    @Autowired
    BarrioService barrioService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<BarrioDTO> findAll() {
        return convertListDTO(barrioService.findAll());
    }

    @Override
    public List<BarrioAllDTO> findInfoAll() {

        String json = barrioService.findInfoAll();
        if (json == null) {
            return new ArrayList<>();
        }
        try {
            return objectMapper.readValue(json, new TypeReference<List<BarrioAllDTO>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    @Override
//    public BarrioDTO findByBarrioName(String barrioName) {
//        Barrio barrio = barrioRepository.findByBarrioName(barrioName);
//        if (barrio == null) {
//            return null;
//        }
//        BarrioDTO barrioDTO = objectMapper.convertValue(barrio, BarrioDTO.class);
//        return barrioDTO;
//    }
//
//    @Override
//    public BarrioDTO findById(Integer id) {
//        Barrio barrio = barrioRepository.findOne(id);
//        if (barrio == null) {
//            return null;
//        }
//        BarrioDTO barrioDTO = objectMapper.convertValue(barrio, BarrioDTO.class);
//        return barrioDTO;
//    }
//
//    @Override
//    public List<BarrioDTO> findAll() {
//        try {
//            List<Barrio> listaBarrio = (List<Barrio>) barrioRepository.findAll();
//            if (listaBarrio == null) {
//                return null;
//            }
//            List<BarrioDTO> listaBarrioDTO = new ArrayList<>();
//
//            listaBarrio.stream().map((barrio) -> {
//                BarrioDTO barrioDTO = new BarrioDTO();
//                barrioDTO.setId(barrio.id());
//                barrioDTO.setPassword(barrio.password());
//                barrioDTO.setBarrioName(barrio.barrioName());
//                return barrioDTO;
//            }).forEachOrdered((barrioDTO) -> {
//                listaBarrioDTO.add(barrioDTO);
//            });
//            return listaBarrioDTO;
//        } catch (Exception ex) {
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public ResponseUtil eliminarBarrio(Integer id) {
//        ResponseUtil responseUtil = new ResponseUtil();
//        try {
//            barrioRepository.delete(id);
//            responseUtil.setTipo(ConstanteUtil.CODE_OK);
//            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
//            return responseUtil;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
//        } catch (DataIntegrityViolationException da) {
//            da.printStackTrace();
//            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
//            responseUtil.setMessage("El usuario esta siendo utilizado.");
//            return responseUtil;
//        }
//        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
//        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
//        return responseUtil;
//    }
    @Override
    public ResponseUtil registrarBarrio(BarrioDTO barrioDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            Barrio barrio = objectMapper.convertValue(barrioDTO, Barrio.class);
            barrioService.save(barrio);
            barrioDTO = objectMapper.convertValue(barrio, BarrioDTO.class);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(barrioDTO);
//            responseUtil.setObjectResponse(barrioDTO);
            return responseUtil;
        } catch (IllegalArgumentException | PropertyAccessException p) {
            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, p);
        } catch (DataIntegrityViolationException da) {
            responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }

    @Override
    public List<BarrioDTO> findByEstado(String estado) {
        return convertListDTO(barrioService.findByEstado(estado));
    }

    @Override
    public List<BarrioDTO> findByNombre(String nombre) {
        return convertListDTO(barrioService.findByNombre(nombre));
    }

    @Override
    public BarrioDTO findByCodigo(String codigo) {
        BarrioDTO barrioDTO = objectMapper.convertValue(barrioService.findByCodigo(codigo), BarrioDTO.class);
        return barrioDTO;
    }

    @Override
    public BarrioDTO findById(Long id) {
        BarrioDTO barrioDTO = objectMapper.convertValue(barrioService.findById(id), BarrioDTO.class);
        return barrioDTO;
    }

    public List<BarrioDTO> convertListDTO(List<Barrio> listBarrios) {
        if (listBarrios.isEmpty()) {
            return new ArrayList<>();
        }

        List<BarrioDTO> listaBarrioDTO = new ArrayList<>();
        listBarrios.stream().map((Barrio barrio) -> {
            BarrioDTO barrioDTO = new BarrioDTO();
            barrioDTO.setId(barrio.id());
            barrioDTO.setCodigo(barrio.codigo());
            barrioDTO.setEstado(barrio.estado());
//            barrioDTO.setIdCiudad(barrio.idCiudad());
            barrioDTO.setIdCiudad(barrio.idCiudad().id());
            barrioDTO.setNombre(barrio.nombre());
            return barrioDTO;
        }).forEachOrdered((barrioDTO) -> {
            listaBarrioDTO.add(barrioDTO);
        });

        return listaBarrioDTO;
    }
}
