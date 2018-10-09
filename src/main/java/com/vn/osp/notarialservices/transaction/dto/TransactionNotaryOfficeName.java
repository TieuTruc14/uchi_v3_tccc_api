package com.vn.osp.notarialservices.transaction.dto;

/**
 * Created by minh on 3/2/2017.
 */
public class TransactionNotaryOfficeName {
    private String notary_office_name;

    private Long type;



    public TransactionNotaryOfficeName() {
    }
    public TransactionNotaryOfficeName(String notary_office_name,Long Type) {
        this.notary_office_name = notary_office_name;
        this.type = Type;
    }


    public String getNotary_office_name() {
        return notary_office_name;
    }

    public void setNotary_office_name(String notary_office_name) {
        this.notary_office_name = notary_office_name;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long Type) {
        this.type = type;
    }

}
