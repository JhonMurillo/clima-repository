/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.domains.valueList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "value_list", schema = "public")
@ApiModel("Model City")
public class ValueList implements Serializable {

    @Id
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty(value = "category", required = true)
    private String category;
    @Column(nullable = false)
    @ApiModelProperty(value = "name", required = true)
    private String description;
    @Column(nullable = false)
    @ApiModelProperty(value = "value", required = true)
    private String value;

    public ValueList() {
    }

    public ValueList(Long id, String category, String description, String value) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.value = value;
    }

    public Long id() {
        return id;
    }

    public String category() {
        return category;
    }

    public String description() {
        return description;
    }

    public String value() {
        return value;
    }

}
