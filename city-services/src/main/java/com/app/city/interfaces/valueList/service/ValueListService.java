/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.interfaces.valueList.service;

import com.app.city.domains.valueList.ValueList;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface ValueListService {

    ValueList save(ValueList person);

    ValueList findById(Long id);

    List<ValueList> findByCategory(String category);

    ValueList findByCategoryAndValue(String category, String value);
}
