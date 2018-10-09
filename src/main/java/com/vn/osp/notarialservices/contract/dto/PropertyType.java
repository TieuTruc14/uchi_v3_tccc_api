package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

/**
 * Created by TienManh on 5/26/2017.
 */
@XStreamAlias("PropertyType")
public class PropertyType extends BaseEntityBeans{
    private String id;
    private String name;
    private String description;

    public PropertyType() {
    }

    @JsonCreator
    public PropertyType(
            @JsonProperty(value="id",required= true) final String id,
            @JsonProperty(value="name",required= true) final String name,
            @JsonProperty(value="description",required= true) final String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getid() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
