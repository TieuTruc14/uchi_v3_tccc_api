package com.vn.osp.notarialservices.transaction.dto;

import java.awt.*;

/**
 * Created by minh on 3/7/2017.
 */
public class NotaryName {

    private String notary_name;



    public NotaryName() {
    }
    public NotaryName(String notary_name) {
        this.notary_name = notary_name;
    }



    public String getNotary_name() {
        return notary_name;
    }

    public void setNotary_name(String notary_name) {
        this.notary_name = notary_name;
    }
}
