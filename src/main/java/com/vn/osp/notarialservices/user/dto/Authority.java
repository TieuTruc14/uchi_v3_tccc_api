package com.vn.osp.notarialservices.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;


@XStreamAlias("Authority")
public class Authority extends BaseEntityBeans {
    private String code;
    private String name;
    private Long entry_user_id;
    private String entry_user_name;
    private String entry_date_time;
    private Long update_user_id;
    private String update_user_name;
    private String update_date_time;
    private Long type;

    public Authority() {
    }

    @JsonCreator
    public Authority(@JsonProperty(value = "id", required = false) final String code,
                     @JsonProperty(value = "name", required = false) final String name,
                     @JsonProperty(value = "entry_user_id", required = false) final Long entry_user_id,
                     @JsonProperty(value = "entry_user_name", required = false) final String entry_user_name,
                     @JsonProperty(value = "entry_date_time", required = false) final String entry_date_time,
                     @JsonProperty(value = "update_user_id", required = false) final Long update_user_id,
                     @JsonProperty(value = "update_user_name", required = false) final String update_user_name,
                     @JsonProperty(value = "update_date_time", required = false) final String update_date_time,
                     @JsonProperty(value = "type", required = false) final Long type) {
        this.code = code;
        this.name = name;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.entry_date_time = entry_date_time;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.update_date_time = update_date_time;
        this.type = type;
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

    public Long getEntry_user_id() {
        return entry_user_id;
    }

    public void setEntry_user_id(Long entry_user_id) {
        this.entry_user_id = entry_user_id;
    }

    public String getEntry_user_name() {
        return entry_user_name;
    }

    public void setEntry_user_name(String entry_user_name) {
        this.entry_user_name = entry_user_name;
    }


    public Long getUpdate_user_id() {
        return update_user_id;
    }

    public void setUpdate_user_id(Long update_user_id) {
        this.update_user_id = update_user_id;
    }

    public String getUpdate_user_name() {
        return update_user_name;
    }

    public void setUpdate_user_name(String update_user_name) {
        this.update_user_name = update_user_name;
    }

    public String getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(String entry_date_time) {
        this.entry_date_time = entry_date_time;
    }

    public String getUpdate_date_time() {
        return update_date_time;
    }

    public void setUpdate_date_time(String update_date_time) {
        this.update_date_time = update_date_time;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
