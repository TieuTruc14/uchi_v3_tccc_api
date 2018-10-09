package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

import java.sql.Timestamp;

/**
 * Created by TienManh on 5/12/2017.
 */
@XStreamAlias("Synchronize")
public class Synchronize extends BaseEntityBeans {
    private int id;
    private int type;
    private String data_id;
    private String authentication_id;
    private int action;
    private Integer history_id;
    private Integer status;
    private Timestamp entry_date_time;

    public Synchronize(){}

    @JsonCreator
    public Synchronize(
            @JsonProperty(value = "id", required = false) int id,
            @JsonProperty(value = "type", required = false) int type,
            @JsonProperty(value = "data_id", required = false) String data_id,
            @JsonProperty(value = "authentication_id", required = false) String authentication_id,
            @JsonProperty(value = "action", required = false) int action,
            @JsonProperty(value = "history_id", required = false) Integer history_id,
            @JsonProperty(value = "status", required = false) Integer status,
            @JsonProperty(value = "entry_date_time", required = false) Timestamp entry_date_time)
    {
        this.id=id;
        this.type=type;
        this.data_id=data_id;
        this.authentication_id=authentication_id;
        this.action=action;
        this.history_id=history_id;
        this.status=status;
        this.entry_date_time=entry_date_time;
    }

    public int getSid() {
        return id;
    }

    public void setSid(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getAuthentication_id() {
        return authentication_id;
    }

    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Integer getHistory_id() {
        return history_id;
    }

    public void setHistory_id(Integer history_id) {
        this.history_id = history_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(Timestamp entry_date_time) {
        this.entry_date_time = entry_date_time;
    }
}
