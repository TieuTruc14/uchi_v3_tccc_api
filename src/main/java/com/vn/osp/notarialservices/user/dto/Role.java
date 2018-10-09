package com.vn.osp.notarialservices.user.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

/**
 * Created by TienManh on 7/17/2017.
 */
@XStreamAlias("Role")
public class Role extends BaseEntityBeans {
    private String code;
    private String name;

    public Role() {
    }

    public Role(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
