package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

/**
 * Created by Admin on 5/8/2017.
 */
@XStreamAlias("ContractTemplateHome")
public class ContractTemplateHome extends BaseEntityBeans {
    private int id;
    private String name;

    public ContractTemplateHome(){

    }

    @JsonCreator
    public ContractTemplateHome(
            @JsonProperty(value = "id", required = false) int id,
            @JsonProperty(value = "name", required = false) String name
    ) {
        this.id = id;
        this.name = name;
    }

    public int getCid() {
        return id;
    }

    public void setCid(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
