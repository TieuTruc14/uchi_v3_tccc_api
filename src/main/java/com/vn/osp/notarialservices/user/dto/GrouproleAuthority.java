package com.vn.osp.notarialservices.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;


@XStreamAlias("GrouproleAuthority")
public class GrouproleAuthority extends BaseEntityBeans {
    private Long grouprole_id;
    private String authority_code;
    private int value;

    @JsonCreator
    public GrouproleAuthority(@JsonProperty(value = "grouprole_id", required = false) final Long grouprole_id,
                              @JsonProperty(value = "authority_code", required = false) final String authority_code,
                              @JsonProperty(value = "value", required = false) final int value) {
        this.grouprole_id = grouprole_id;
        this.authority_code = authority_code;
        this.value = value;
    }

    public GrouproleAuthority() {
    }

    public Long getGrouprole_id() {
        return grouprole_id;
    }

    public void setGrouprole_id(Long grouprole_id) {
        this.grouprole_id = grouprole_id;
    }

    public String getAuthority_code() {
        return authority_code;
    }

    public void setAuthority_code(String authority_code) {
        this.authority_code = authority_code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
