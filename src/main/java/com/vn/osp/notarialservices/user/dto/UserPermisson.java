package com.vn.osp.notarialservices.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

/**
 * Created by tranv on 3/8/2017.
 */

@XStreamAlias("UserPermisson")
public class UserPermisson extends BaseEntityBeans {
    private Long userId;
    private String cb01;

    @JsonCreator
    public UserPermisson(@JsonProperty(value = "userId", required = false) final Long userId,
                         @JsonProperty(value = "cb01", required = false) final String cb01) {
        this.userId = userId;
        this.cb01 = cb01;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCb01() {
        return cb01;
    }

    public void setCb01(String cb01) {
        this.cb01 = cb01;
    }
}
