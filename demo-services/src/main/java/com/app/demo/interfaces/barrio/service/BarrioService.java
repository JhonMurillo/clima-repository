/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.service;

import com.app.demo.domains.barrio.Barrio;
import com.app.demo.interfaces.barrio.dto.BarrioAllDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface BarrioService {

    List<Barrio> findAll();

    List<BarrioAllDTO> findInfoAll();
}
