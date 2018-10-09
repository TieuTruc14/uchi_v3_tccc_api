package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

import java.sql.Timestamp;

@XStreamAlias("ContractHistoryInfor")
public class ContractHistoryInfor extends BaseEntityBeans {
  private Integer hid;
  private Integer contract_id;
  private String contract_number;
  private String client_info;
  private String execute_date_time;
  private String execute_person;
  private String execute_content;
  private String contract_content;



  public ContractHistoryInfor() {
  }

  @JsonCreator
  public ContractHistoryInfor(
          @JsonProperty(value="hid",required= true) final Integer hid,
          @JsonProperty(value="contract_id",required= true) final Integer contract_id,
          @JsonProperty(value="contract_number",required= true) final String contract_number,
          @JsonProperty(value="client_info",required= true) final String client_info,
          @JsonProperty(value="execute_date_time",required= true) final String execute_date_time,
          @JsonProperty(value="execute_person",required= true) final String execute_person,
          @JsonProperty(value="execute_content",required= true) final String execute_content,
          @JsonProperty(value="contract_content",required= true) final String contract_content
  ) {
    this.hid = hid;
    this.contract_id = contract_id;
    this.contract_number = contract_number;
    this.client_info = client_info;
    this.execute_date_time = execute_date_time;
    this.execute_person = execute_person;
    this.execute_content = execute_content;
    this.contract_content = contract_content;

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
