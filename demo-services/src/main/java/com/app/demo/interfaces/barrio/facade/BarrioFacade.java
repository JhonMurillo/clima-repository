/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.facade;

import com.app.demo.utils.ResponseUtil;
import com.app.demo.interfaces.barrio.dto.BarrioAllDTO;
import com.app.demo.interfaces.barrio.dto.BarrioDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface BarrioFacade {

    List<BarrioDTO> findAll();

    List<BarrioAllDTO> findInfoAll();

    ResponseUtil registrarBarrio(BarrioDTO barrioDTO);

    List<BarrioDTO> findByEstado(String estado);

    List<BarrioDTO> findByNombre(String nombre);

    BarrioDTO findByCodigo(String codigo);

    BarrioDTO findById(Long id);

}
