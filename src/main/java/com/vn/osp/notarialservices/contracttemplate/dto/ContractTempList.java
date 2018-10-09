package com.vn.osp.notarialservices.contracttemplate.dto;

import io.swagger.models.auth.In;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

/**
 * Created by Admin on 28/7/2017.
 */
public class ContractTempList {
    private Integer id;
    private String name;
    private String code;
    private Boolean active_flg;
    private String contractKindName;

    public ContractTempList() {
    }

    public ContractTempList(Integer id, String name, String code, Boolean active_flg, String contractKindName) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active_flg = active_flg;
        this.contractKindName = contractKindName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getContractKindName() {
        return contractKindName;
    }

    public void setContractKindName(String contractKindName) {
        this.contractKindName = contractKindName;
    }

    public Boolean getActive_flg() {
        return active_flg;
    }

    public void setActive_flg(Boolean active_flg) {
        this.active_flg = active_flg;
    }
}
