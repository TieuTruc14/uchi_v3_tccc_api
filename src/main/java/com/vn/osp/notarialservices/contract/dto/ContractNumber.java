package com.vn.osp.notarialservices.contract.dto;

import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

/**
 * Created by TienManh on 6/15/2017.
 */
public class ContractNumber extends BaseEntityBeans {
    private String kind_id;
    private long contract_number;

    public ContractNumber() {
    }


    public String getKind_id() {
        return kind_id;
    }

    public void setKind_id(String kind_id) {
        this.kind_id = kind_id;
    }

    public long getContract_number() {
        return contract_number;
    }

    public void setContract_number(long contract_number) {
        this.contract_number = contract_number;
    }
}
