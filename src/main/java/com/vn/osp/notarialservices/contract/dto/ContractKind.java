package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

public class ContractKind extends BaseEntityBeans {
  private Long id;
  private String name;
  private Long parent_kind_id;
  private Long order_number;
  private Long entry_user_id;
  private String entry_user_name;
  private String entry_date_time;
  private Long update_user_id;
  private String update_user_name;
  private String update_date_time;
  private String contract_kind_code;
  @JsonCreator
  public ContractKind(            @JsonProperty(value = "id") final Long id,
                                  @JsonProperty(value = "name")final String name,
                                  @JsonProperty(value = "parent_kind_id") final Long parent_kind_id,
                                  @JsonProperty(value = "order_number") final Long order_number,
                                  @JsonProperty(value = "entry_user_id") final Long entry_user_id,
                                  @JsonProperty(value = "entry_user_name") final String entry_user_name,
                                  @JsonProperty(value = "entry_date_time") final String entry_date_time,
                                  @JsonProperty(value = "update_user_id") final Long update_user_id,
                                  @JsonProperty(value = "update_user_name") final String update_user_name,
                                  @JsonProperty(value = "update_date_time") final String update_date_time,
                                  @JsonProperty(value = "contract_kind_code") final String contract_kind_code
  ){
    this.id = id;
    this.name = name;
    this.parent_kind_id = parent_kind_id;
    this.order_number = order_number;
    this.entry_user_id = entry_user_id;
    this.entry_user_name = entry_user_name;
    this.entry_date_time = entry_date_time;
    this.update_user_id = update_user_id;
    this.update_user_name = update_user_name;
    this.update_date_time = update_date_time;
    this.contract_kind_code = contract_kind_code;

  }


  public ContractKind(Long id, String name, Long parent_kind_id, Long order_number, Long entry_user_id, String entry_user_name, String entry_date_time, Long update_user_id, String update_user_name, String update_date_time) {
        this.id = id;
        this.name = name;
        this.parent_kind_id = parent_kind_id;
        this.order_number = order_number;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.entry_date_time = entry_date_time;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.update_date_time = update_date_time;
    }

    public ContractKind() {
    }

    public Long getContractKindId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getParent_kind_id() {
    return parent_kind_id;
  }

  public void setParent_kind_id(Long parent_kind_id) {
    this.parent_kind_id = parent_kind_id;
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

  public String getContract_kind_code() {
    return contract_kind_code;
  }

  public void setContract_kind_code(String contract_kind_code) {
    this.contract_kind_code = contract_kind_code;
  }
}
