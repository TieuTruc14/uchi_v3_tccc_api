package com.vn.osp.notarialservices.transaction.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table( name ="npo_transaction_property")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_transaction_property_add",
                procedureName = "vpcc_npo_transaction_property_add",
                parameters = {
                        @StoredProcedureParameter(name = "xml_transaction_property", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "findTransactionByFilter",
                procedureName = "stp_npo_transaction_property_select_by_filter",
                resultClasses = { TransactionPropertyBo.class },
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_transaction_property_count_total_by_filter",
                procedureName = "stp_npo_transaction_property_count_total_by_filter",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "findTransactionByBank",
                procedureName = "stp_npo_select_by_bank",
                resultClasses = { TransactionPropertyBo.class },
                parameters = {
                        @StoredProcedureParameter(name = "bankname", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "numOffset", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "numLimit", type = Integer.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "selectReportByNotary",
                procedureName = "stp_npo_report_by_notary",
                resultClasses = { TransactionPropertyBo.class },
                parameters = {
                        @StoredProcedureParameter(name = "notaryOfficeName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "numOffset", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "numLimit", type = Integer.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "selectReportByUser",
                procedureName = "stp_npo_report_by_user",
                resultClasses = { TransactionPropertyBo.class },
                parameters = {
                        @StoredProcedureParameter(name = "notaryOfficeName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entryUserName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "numOffset", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "numLimit", type = Integer.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "selectContractCertify",
                procedureName = "stp_npo_select_contract_certify",
                resultClasses = { TransactionPropertyBo.class },
                parameters = {
                        @StoredProcedureParameter(name = "contractKind", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "selectNotary",
                procedureName = "stp_select_notary_name",
                parameters = {
                        @StoredProcedureParameter(name = "notaryOffice", type = String.class, mode = ParameterMode.IN),
                }

        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_transaction_synchronize_ok",
                procedureName = "vpcc_npo_transaction_synchronize_ok",
                parameters = {
                        @StoredProcedureParameter(name = "notaryOfficeCode", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "contract_kind", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "contractNumber", type = String.class, mode = ParameterMode.IN),
                }

        ),

        @NamedStoredProcedureQuery(
                name = "selectEntryUserName",
                procedureName = "stp_npo_select_user_name_report",
                parameters = {
                        @StoredProcedureParameter(name = "notaryOffice", type = String.class, mode = ParameterMode.IN),
                }

        ),
        @NamedStoredProcedureQuery(
                name = "selectVPCC",
                procedureName = "stp_npo_select_VPCC"
        ),
        @NamedStoredProcedureQuery(
                name = "countTotalContractByBank",
                procedureName = "stp_npo_count_total_contract_by_bank",
                parameters = {
                        @StoredProcedureParameter(name = "bankname", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "countTotalReportByNotary",
                procedureName = "stp_npo_count_total_report_by_notary",
                parameters = {
                        @StoredProcedureParameter(name = "notaryOfficeName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "countTotalReportByUser",
                procedureName = "stp_npo_report_by_user_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "notaryOfficeName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entryUserName", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "getByContractId",
                procedureName = "vpcc_npo_transaction_property_get_by_contract_id",
                resultClasses = { TransactionPropertyBo.class },
                parameters = {
                        @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_transaction_property_update_syn_status",
                procedureName = "vpcc_npo_transaction_property_update_syn_status",
                parameters = {
                        @StoredProcedureParameter(name = "tpid", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "syn_status", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_report_by_bank",
                procedureName = "vpcc_report_by_bank",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_report_bank_count_total",
                procedureName = "vpcc_report_bank_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),

})
public class TransactionPropertyBo extends AbstractAuditEntity implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "tpid", nullable = false)
  private Long id;

  @Column(name = "synchronize_id")
  private String synchronize_id;
  @Column(name = "type")
  private String type;
  @Column(name = "property_info")
  private String property_info;
  @Column(name = "land_street")
  private String land_street;
  @Column(name = "land_district")
  private String land_district;
  @Column(name = "land_province")
  private String land_province;
  @Column(name = "land_full_of_area")
  private String land_full_of_area;
  @Column(name = "transaction_content")
  private String transaction_content;
  @Column(name = "notary_date")
  private java.sql.Timestamp notary_date;
  @Column(name = "notary_office_name")
  private String notary_office_name;
  @Column(name = "contract_id")
  private Long contract_id;
  @Column(name = "contract_number")
  private String contract_number;
  @Column(name = "contract_name")
  private String contract_name;
  @Column(name = "contract_kind")
  private String contract_kind;
  @Column(name = "code_template")
  private Long code_template;
  @Column(name = "contract_value")
  private String contract_value;
  @Column(name = "relation_object")
  private String relation_object;
  @Column(name = "notary_person")
  private String notary_person;
  @Column(name = "notary_place")
  private String notary_place;
  @Column(name = "notary_fee")
  private Long notary_fee;
  @Column(name = "remuneration_cost")
  private Long remuneration_cost;
  @Column(name = "notary_cost_total")
  private Long notary_cost_total;
  @Column(name = "note")
  private String note;
  @Column(name = "contract_period")
  private String contract_period;
  @Column(name = "mortage_cancel_flag")
  private Long mortage_cancel_flag;
  @Column(name = "mortage_cancel_date")
  private String mortage_cancel_date;
  @Column(name = "mortage_cancel_note")
  private String mortage_cancel_note;
  @Column(name = "cancel_status")
  private Long cancel_status;
  @Column(name = "cancel_description")
  private String cancel_description;
  @Column(name = "entry_user_id")
  private Long entry_user_id;
  @Column(name = "entry_user_name")
  private String entry_user_name;
  @Column(name = "entry_date_time")
  private java.sql.Timestamp entry_date_time;
  @Column(name = "update_user_id")
  private Long update_user_id;
  @Column(name = "update_user_name")
  private String update_user_name;
  @Column(name = "update_date_time")
  private java.sql.Timestamp update_date_time;
  @Column(name = "bank_id")
  private Long bank_id;
  @Column(name = "bank_name")
  private String bank_name;
  @Column(name = "bank_code")
  private String bank_code;
  @Column(name = "syn_status")
  private Integer syn_status;
  @Column(name = "json_property")
  private String json_property;
  @Column(name = "json_person")
  private String json_person;

  public TransactionPropertyBo() {
  }

  public TransactionPropertyBo(Long id,String synchronize_id, String type, String property_info, String land_street, String land_district, String land_province, String land_full_of_area, String transaction_content, Timestamp notary_date, String notary_office_name, Long contract_id, String contract_number, String contract_name, String contract_kind,Long code_template, String contract_value, String relation_object, String notary_person, String notary_place, Long notary_fee,Long remuneration_cost,Long notary_cost_total, String note, String contract_period, Long mortage_cancel_flag, String mortage_cancel_date, String mortage_cancel_note, Long cancel_status, String cancel_description, Long entry_user_id, String entry_user_name, Timestamp entry_date_time, Long update_user_id, String update_user_name, Timestamp update_date_time, Long bank_id, String bank_name, String bank_code, Integer syn_status, String json_property, String json_person) {
    this.id = id;
    this.synchronize_id = synchronize_id;
    this.type = type;
    this.property_info = property_info;
    this.land_street = land_street;
    this.land_district = land_district;
    this.land_province = land_province;
    this.land_full_of_area = land_full_of_area;
    this.transaction_content = transaction_content;
    this.notary_date = notary_date;
    this.notary_office_name = notary_office_name;
    this.contract_id = contract_id;
    this.contract_number = contract_number;
    this.contract_name = contract_name;
    this.contract_kind = contract_kind;
    this.code_template=code_template;
    this.contract_value = contract_value;
    this.relation_object = relation_object;
    this.notary_person = notary_person;
    this.notary_place = notary_place;
    this.notary_fee = notary_fee;
    this.remuneration_cost=remuneration_cost;
    this.notary_cost_total=notary_cost_total;
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
    this.syn_status = syn_status;
    this.json_property = json_property;
    this.json_person = json_person;
  }

  public Long getTpid() {
    return id;
  }

  public void setTpid(Long tpid) {
    this.id = tpid;
  }

  public Long getId(){return id;}

  public void setId(Long id){this.id = id;}

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

  public java.sql.Timestamp getNotary_date() {
    return notary_date;
  }

  public void setNotary_date(java.sql.Timestamp notary_date) {
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

  public Long getCode_template() {
    return code_template;
  }

  public void setCode_template(Long code_template) {
    this.code_template = code_template;
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

  public java.sql.Timestamp getEntry_date_time() {
    return entry_date_time;
  }

  public void setEntry_date_time(java.sql.Timestamp entry_date_time) {
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

  public java.sql.Timestamp getUpdate_date_time() {
    return update_date_time;
  }

  public void setUpdate_date_time(java.sql.Timestamp update_date_time) {
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
