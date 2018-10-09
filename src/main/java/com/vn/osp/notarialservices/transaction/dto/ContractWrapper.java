package com.vn.osp.notarialservices.transaction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;
import com.vn.osp.notarialservices.contract.dto.Contract;
import com.vn.osp.notarialservices.contract.dto.Property;

/**
 * Created by TienManh on 5/15/2017.
 */
public class ContractWrapper extends BaseEntityBeans {
    private Contract contract;
    private Property property;

    public ContractWrapper() {
    }

    public ContractWrapper(Contract contract, Property property) {
        this.contract = contract;
        this.property = property;
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
