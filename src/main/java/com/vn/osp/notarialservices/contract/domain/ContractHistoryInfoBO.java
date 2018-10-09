package com.vn.osp.notarialservices.contract.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by TienManh on 8/14/2017.
 */
@Data
@Entity
@Table(name = "npo_contract_history")
public class ContractHistoryInfoBO extends AbstractAuditEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hid", nullable = false)
    private Integer hid;

    @Column(name = "contract_id")
    private Integer contract_id;

    @Column(name = "contract_number")
    private String contract_number;

    @Column(name = "client_info")
    private String client_info;

    @Column(name = "execute_date_time")
    private String execute_date_time;

    @Column(name = "execute_person")
    private String execute_person;

    @Column(name = "execute_content")
    private String execute_content;

    @Column(name = "contract_content")
    private String contract_content;

    public ContractHistoryInfoBO(Integer hid,Integer contract_id, String contract_number, String client_info, String execute_date_time, String execute_person, String execute_content, String contract_content) {
        this.hid = hid;
        this.contract_id = contract_id;
        this.contract_number = contract_number;
        this.client_info = client_info;
        this.execute_date_time = execute_date_time;
        this.execute_person = execute_person;
        this.execute_content = execute_content;
        this.contract_content = contract_content;
    }

    public ContractHistoryInfoBO() {
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getClient_info() {
        return client_info;
    }

    public void setClient_info(String client_info) {
        this.client_info = client_info;
    }

    public String getExecute_date_time() {
        return execute_date_time;
    }

    public void setExecute_date_time(String execute_date_time) {
        this.execute_date_time = execute_date_time;
    }

    public String getExecute_person() {
        return execute_person;
    }

    public void setExecute_person(String execute_person) {
        this.execute_person = execute_person;
    }

    public String getExecute_content() {
        return execute_content;
    }

    public void setExecute_content(String execute_content) {
        this.execute_content = execute_content;
    }

    public String getContract_content() {
        return contract_content;
    }

    public void setContract_content(String contract_content) {
        this.contract_content = contract_content;
    }
}
