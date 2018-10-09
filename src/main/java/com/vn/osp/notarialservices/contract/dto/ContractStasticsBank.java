package com.vn.osp.notarialservices.contract.dto;

/**
 * Created by minh on 5/29/2017.
 */
public class ContractStasticsBank {
    private Integer bank_id;
    private String bank_name;
    private Integer number_of_contract;

    public ContractStasticsBank(){

    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public Integer getNumber_of_contract() {
        return number_of_contract;
    }

    public void setNumber_of_contract(Integer number_of_contract) {
        this.number_of_contract = number_of_contract;
    }
}
