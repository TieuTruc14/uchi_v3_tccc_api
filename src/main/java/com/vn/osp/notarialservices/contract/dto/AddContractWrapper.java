package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

/**
 * Created by TienManh on 5/15/2017.
 */
public class AddContractWrapper extends BaseEntityBeans {
    private Contract contract=new Contract();
    private Property property=new Property();

    public AddContractWrapper(){}

    @JsonCreator
    public AddContractWrapper(@JsonProperty(value = "contract", required = true) Contract contract,
                              @JsonProperty(value = "property", required = true) Property property){
        this.contract=contract;
        this.property=property;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
