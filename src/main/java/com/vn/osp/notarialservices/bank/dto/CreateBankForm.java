package com.vn.osp.notarialservices.bank.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.models.auth.In;

/**
 * Created by nmha on 3/28/2017.
 */
public class CreateBankForm {
    private Integer id;
    private String name;
    private String code;
    private Long order_number;
    private Long entry_user_id;
    private String entry_user_name;
    private String entry_date_time;
    private Long update_user_id;
    private String update_user_name;
    private String update_date_time;
    private Long active;

    @JsonCreator
    public CreateBankForm(@JsonProperty(value = "id", required = false) final Integer id,
                               @JsonProperty(value = "name", required = false) final String name,
                               @JsonProperty(value = "order_number", required = false) final Long order_number,
                               @JsonProperty(value = "code", required = false) final String code,
                               @JsonProperty(value = "active", required = false) final Long active,
                               @JsonProperty(value = "entry_user_id", required = false) final Long entry_user_id,
                               @JsonProperty(value = "entry_user_name", required = false) final String entry_user_name,
                               @JsonProperty(value = "entry_date_time", required = false) final String entry_date_time,
                               @JsonProperty(value = "update_user_id", required = false) final Long update_user_id,
                               @JsonProperty(value = "update_user_name", required = false) final String update_user_name,
                               @JsonProperty(value = "update_date_time", required = false) final String update_date_time
                              ) {
        this.id = id;
        this.name = name;
        this.order_number = order_number;
        this.code = code;
        this.active = active;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.entry_date_time = entry_date_time;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.update_date_time = update_date_time;
    }

    public CreateBankForm() {
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

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
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

    public String getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(String entry_date_time) {
        this.entry_date_time = entry_date_time;
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

    public String getUpdate_date_time() {
        return update_date_time;
    }

    public void setUpdate_date_time(String update_date_time) {
        this.update_date_time = update_date_time;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }
}
