package com.vn.osp.notarialservices.transaction.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nmha on 3/18/2017.
 */
public class SynchonizeContractKey {

    private String notaryOfficeCode;
    private String contractKindCode;
    private String contractNumber;

    public SynchonizeContractKey() {
    }

    @JsonCreator
    public SynchonizeContractKey(@JsonProperty("notaryOfficeCode") String notaryOfficeCode,
                                 @JsonProperty("contractKindCode") String contractKindCode,
                                 @JsonProperty("contractNumber") String contractNumber) {
        this.notaryOfficeCode = notaryOfficeCode;
        this.contractKindCode = contractKindCode;
        this.contractNumber = contractNumber;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"notaryOfficeCode\":\"").append(notaryOfficeCode).append("\",");
        sb.append("\"contractKindCode\":\"").append(contractKindCode).append("\",");
        sb.append("\"contractNumber\":\"").append(contractNumber).append("\",");
        sb.append('}');
        return sb.toString();
    }

    public String getNotaryOfficeCode() {
        return notaryOfficeCode;
    }

    public void setNotaryOfficeCode(String notaryOfficeCode) {
        this.notaryOfficeCode = notaryOfficeCode;
    }

    public String getContractKindCode() {
        return contractKindCode;
    }

    public void setContractKindCode(String contractKindCode) {
        this.contractKindCode = contractKindCode;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }
}
