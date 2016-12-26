/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.domains.valueList;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface ValueListRepository extends CrudRepository<ValueList, Long> {

    List<ValueList> findByCategory(String category);

    ValueList findByCategoryAndValue(String category, String value);
}
