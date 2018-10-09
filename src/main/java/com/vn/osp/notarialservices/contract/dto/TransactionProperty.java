package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

import java.sql.Timestamp;

/**
 * Created by TienManh on 5/11/2017.
 */
@XStreamAlias("TransactionProperty")
public class TransactionProperty extends BaseEntityBeans {

    private Long tpid;
    private String synchronize_id;
    private String type;
    private String property_info;
    private String land_street;
    private String land_district;
    private String land_province;
    private String land_full_of_area;
    private String transaction_content;
    private String notary_date;
    private String notary_office_name;
    private Long contract_id;
    private String contract_number;
    private String contract_name;
    private String contract_kind;
    private String contract_value;
    private String relation_object;
    private String notary_person;
    private String notary_place;
    private Long notary_fee;
    private Long remuneration_cost;
    private Long notary_cost_total;
    private String note;
    private String contract_period;
    private Long mortage_cancel_flag;
    private String mortage_cancel_date;
    private String mortage_cancel_note;
    private Long cancel_status;
    private String cancel_description;
    private Long entry_user_id;
    private String entry_user_name;
    private String entry_date_time;
    private Long update_user_id;
    private String update_user_name;
    private String update_date_time;
    private Long bank_id;
    private String bank_name;
    private String bank_code;
    private Integer syn_status;
    private String json_property;
    private String json_person;

    @JsonCreator
    public TransactionProperty (
            @JsonProperty(value = "tpid", required = true) final Long tpid,
            @JsonProperty(value = "synchronize_id", required = false) final String synchronize_id,
            @JsonProperty(value = "type", required = true) final String type,
            @JsonProperty(value = "property_info", required = true) final String property_info,
            @JsonProperty(value = "land_street", required = true) final String land_street,
            @JsonProperty(value = "land_district", required = true) final String land_district,
            @JsonProperty(value = "land_province", required = true) final String land_province,
            @JsonProperty(value = "land_full_of_area", required = true) final String land_full_of_area,
            @JsonProperty(value = "transaction_content", required = true) final String transaction_content,
            @JsonProperty(value = "notary_date", required = true) final String notary_date,
            @JsonProperty(value = "notary_office_name", required = true) final String notary_office_name,
            @JsonProperty(value = "contract_id", required = true) final Long contract_id,
            @JsonProperty(value = "contract_number", required = true) final String contract_number,
            @JsonProperty(value = "contract_name", required = true) final String contract_name,
            @JsonProperty(value = "contract_kind", required = true) final String contract_kind,
            @JsonProperty(value = "contract_value", required = true) final String contract_value,
            @JsonProperty(value = "relation_object", required = true) final String relation_object,
            @JsonProperty(value = "notary_person", required = true) final String notary_person,
            @JsonProperty(value = "notary_place", required = true) final String notary_place,
            @JsonProperty(value = "notary_fee", required = true) final Long notary_fee,
            @JsonProperty(value = "remuneration_cost", required = true) final Long remuneration_cost,
            @JsonProperty(value = "notary_cost_total", required = true) final Long notary_cost_total,
            @JsonProperty(value = "note", required = true) final String note,
            @JsonProperty(value = "contract_period", required = true) final String contract_period,
            @JsonProperty(value = "mortage_cancel_flag", required = true) final Long mortage_cancel_flag,
            @JsonProperty(value = "mortage_cancel_date", required = true) final String mortage_cancel_date,
            @JsonProperty(value = "mortage_cancel_note", required = true) final String mortage_cancel_note,
            @JsonProperty(value = "cancel_status", required = true) final Long cancel_status,
            @JsonProperty(value = "cancel_description", required = true) final String cancel_description,
            @JsonProperty(value = "entry_user_id", required = true) final Long entry_user_id,
            @JsonProperty(value = "entry_user_name", required = true) final String entry_user_name,
            @JsonProperty(value = "entry_date_time", required = true) final String entry_date_time,
            @JsonProperty(value = "update_user_id", required = true) final Long update_user_id,
            @JsonProperty(value = "update_user_name", required = true) final String update_user_name,
            @JsonProperty(value = "update_date_time", required = true) final String update_date_time,
            @JsonProperty(value = "bank_id", required = true) final Long bank_id,
            @JsonProperty(value = "bank_name", required = true) final String bank_name,
            @JsonProperty(value = "bank_code", required = true) final String bank_code,
            @JsonProperty(value = "syn_status", required = true) final Integer syn_status,
            @JsonProperty(value = "json_property", required = true) final String json_property,
            @JsonProperty(value = "json_person", required = true) final String json_person


    ){
        this.tpid = tpid;
        this.synchronize_id = synchronize_id;
        this.type = type;
        this.property_info = property_info;
        this.land_street = land_street;
        this.land_district = land_district;
        this.land_full_of_area = land_full_of_area;
        this.transaction_content = transaction_content;
        this.notary_date = notary_date;
        this.notary_office_name = notary_office_name;
        this.contract_id = contract_id;
        this.contract_number = contract_number;
        this.contract_name = contract_name;
        this.contract_kind = contract_kind;
        this.contract_value = contract_value;
        this.relation_object = relation_object;
        this.notary_person = notary_person;
        this.notary_place = notary_place;
        this.notary_fee = notary_fee;
        this.remuneration_cost = remuneration_cost;
        this.notary_cost_total = notary_cost_total;
        this.note = note;
        this.contract_period = contract_period;
        this.mortage_cancel_flag = mortage_cancel_flag;
        this.mortage_cancel_date = mortage_cancel_date;
        this.mortage_cancel_note = mortage_cancel_note;
        this.cancel_status = cancel_status;
        this.cancel_description = cancel_description;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.entry_date_time = entry_date_time;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.update_date_time = update_date_time;
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.bank_code = bank_code;
        this.syn_status=syn_status;
        this.json_property=json_property;
        this.json_person=json_person;
    }

    public TransactionProperty() {
    }

    public Long getTpid() {
        return tpid;
    }

    public void setTpid(Long tpid) {
        this.tpid = tpid;
    }

    public String getSynchronize_id() {
        return synchronize_id;
    }

    public void setSynchronize_id(String synchronize_id) {
        this.synchronize_id = synchronize_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperty_info() {
        return property_info;
    }

    public void setProperty_info(String property_info) {
        this.property_info = property_info;
    }

    public String getLand_street() {
        return land_street;
    }

    public void setLand_street(String land_street) {
        this.land_street = land_street;
    }

    public String getLand_district() {
        return land_district;
    }

    public void setLand_district(String land_district) {
        this.land_district = land_district;
    }

    public String getLand_province() {
        return land_province;
    }

    public void setLand_province(String land_province) {
        this.land_province = land_province;
    }

    public String getLand_full_of_area() {
        return land_full_of_area;
    }

    public void setLand_full_of_area(String land_full_of_area) {
        this.land_full_of_area = land_full_of_area;
    }

    public String getTransaction_content() {
        return transaction_content;
    }

    public void setTransaction_content(String transaction_content) {
        this.transaction_content = transaction_content;
    }

    public String getNotary_date() {
        return notary_date;
    }

    public void setNotary_date(String notary_date) {
        this.notary_date = notary_date;
    }

    public String getNotary_office_name() {
        return notary_office_name;
    }

    public void setNotary_office_name(String notary_office_name) {
        this.notary_office_name = notary_office_name;
    }

    public Long getContract_id() {
        return contract_id;
    }

    public void setContract_id(Long contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getContract_kind() {
        return contract_kind;
    }

    public void setContract_kind(String contract_kind) {
        this.contract_kind = contract_kind;
    }

    public String getContract_value() {
        return contract_value;
    }

    public void setContract_value(String contract_value) {
        this.contract_value = contract_value;
    }

    public String getRelation_object() {
        return relation_object;
    }

    public void setRelation_object(String relation_object) {
        this.relation_object = relation_object;
    }

    public String getNotary_person() {
        return notary_person;
    }

    public void setNotary_person(String notary_person) {
        this.notary_person = notary_person;
    }

    public String getNotary_place() {
        return notary_place;
    }

    public void setNotary_place(String notary_place) {
        this.notary_place = notary_place;
    }

    public Long getNotary_fee() {
        return notary_fee;
    }

    public void setNotary_fee(Long notary_fee) {
        this.notary_fee = notary_fee;
    }

    public Long getRemuneration_cost() {
        return remuneration_cost;
    }

    public void setRemuneration_cost(Long remuneration_cost) {
        this.remuneration_cost = remuneration_cost;
    }

    public Long getNotary_cost_total() {
        return notary_cost_total;
    }

    public void setNotary_cost_total(Long notary_cost_total) {
        this.notary_cost_total = notary_cost_total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContract_period() {
        return contract_period;
    }

    public void setContract_period(String contract_period) {
        this.contract_period = contract_period;
    }

    public Long getMortage_cancel_flag() {
        return mortage_cancel_flag;
    }

    public void setMortage_cancel_flag(Long mortage_cancel_flag) {
        this.mortage_cancel_flag = mortage_cancel_flag;
    }

    public String getMortage_cancel_date() {
        return mortage_cancel_date;
    }

    public void setMortage_cancel_date(String mortage_cancel_date) {
        this.mortage_cancel_date = mortage_cancel_date;
    }

    public String getMortage_cancel_note() {
        return mortage_cancel_note;
    }

    public void setMortage_cancel_note(String mortage_cancel_note) {
        this.mortage_cancel_note = mortage_cancel_note;
    }

    public Long getCancel_status() {
        return cancel_status;
    }

    public void setCancel_status(Long cancel_status) {
        this.cancel_status = cancel_status;
    }

    public String getCancel_description() {
        return cancel_description;
    }

    public void setCancel_description(String cancel_description) {
        this.cancel_description = cancel_description;
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

    public Long getBank_id() {
        return bank_id;
    }

    public void setBank_id(Long bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public Integer getSyn_status() {
        return syn_status;
    }

    public void setSyn_status(Integer syn_status) {
        this.syn_status = syn_status;
    }

    public String getJson_property() {
        return json_property;
    }

    public void setJson_property(String json_property) {
        this.json_property = json_property;
    }

    public String getJson_person() {
        return json_person;
    }

    public void setJson_person(String json_person) {
        this.json_person = json_person;
    }
}
