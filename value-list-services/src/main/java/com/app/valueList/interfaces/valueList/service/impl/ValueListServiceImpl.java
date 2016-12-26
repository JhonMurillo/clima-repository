/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.valueList.interfaces.valueList.service.impl;

import com.app.valueList.domains.valueList.ValueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.valueList.domains.valueList.ValueListRepository;
import com.app.valueList.interfaces.valueList.service.ValueListService;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
@Component("valueListService")
public class ValueListServiceImpl implements ValueListService {

    @Autowired
    ValueListRepository valueListRepository;

    @Override
    public ValueList save(ValueList valueList) {
        return valueListRepository.save(valueList);
    }

    @Override
    public List<ValueList> findAll() {
        return (List<ValueList>) valueListRepository.findAll();
    }

    @Override
    public ValueList findById(Long id) {
        return valueListRepository.findOne(id);
    }

    @Override
    public List<ValueList> findByCategory(String category) {
        return (List<ValueList>) valueListRepository.findByCategory(category);
    }

    @Override
    public ValueList findByCategoryAndValue(String category, String value) {
        return valueListRepository.findByCategoryAndValue(category, value);
    }
}
