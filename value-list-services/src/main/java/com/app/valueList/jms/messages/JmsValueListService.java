/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.valueList.jms.messages;

import com.app.valueList.interfaces.valueList.dto.ValueListDTO;

/**
 *
 * @author Desarrollo4
 */
public interface JmsValueListService {

    void sendValueList(ValueListDTO valueListDTO);

}
