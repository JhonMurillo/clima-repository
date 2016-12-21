/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.service.impl;

import com.app.demo.domains.barrio.Barrio;
import com.app.demo.domains.barrio.BarrioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.demo.interfaces.barrio.service.BarrioService;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("barrioService")
@Service
public class BarrioServiceImpl implements BarrioService {

    @Autowired
    BarrioRepository barrioRepository;

    @Override
    public List<Barrio> findAll() {
        return (List<Barrio>) barrioRepository.findAll();
    }

    @Override
    public String findInfoAll() {
        return barrioRepository.findByBarrioCiudadDeparPais();
    }

    @Override
    public Barrio save(Barrio barrio) {
        return barrioRepository.save(barrio);
    }

    @Override
    public Barrio findById(Long id) {
        return barrioRepository.findOne(id);
    }

    @Override
    public List<Barrio> findByEstado(String estado) {
        return barrioRepository.findByEstado(estado);
    }

    @Override
    public Barrio findByCodigo(String codigo) {
       return barrioRepository.findByCodigo(codigo);
    }

    @Override
    public List<Barrio> findByNombre(String nombre) {
        return barrioRepository.findByNombre(nombre);
    }

}
