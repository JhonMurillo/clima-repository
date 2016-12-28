/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.valueList.facade;

import com.app.weather.interfaces.valueList.dto.ValueListDTO;
import com.app.weather.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface ValueListFacade {

    ResponseUtil save(ValueListDTO valueListDTO);

//    List<ValueListDTO> findAll();

    ValueListDTO findById(Long id);

    List<ValueListDTO> findByCategory(String category);

    ValueListDTO findByCategoryAndValue(String category, String value);
}
