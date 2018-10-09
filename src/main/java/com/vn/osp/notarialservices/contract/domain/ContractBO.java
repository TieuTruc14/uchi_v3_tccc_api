package com.vn.osp.notarialservices.contract.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Admin on 5/8/2017.
 */
@Data
@Entity
@Table(name = "npo_contract")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_contract_select_by_filter",
                procedureName = "stp_npo_contract_select_by_filter",
                resultClasses = {ContractBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "strFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_select_by_id",
                procedureName = "vpcc_npo_contract_select_by_id",
                resultClasses = {ContractBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name="stp_npo_contact_select_all",
                procedureName = "stp_npo_contract_select_all",
                resultClasses = {ContractBO.class}
        ),
        @NamedStoredProcedureQuery(
                name="stp_npo_contact_select_list",
                procedureName = "stp_npo_contract_select_list",
                resultClasses = {ContractBO.class}
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_contract_property_add",
                procedureName = "stp_npo_contract_property_add",
                parameters = {
                        @StoredProcedureParameter(name = "xml_contract", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_property", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_add",
                procedureName = "vpcc_npo_contract_add",
                parameters = {
                        @StoredProcedureParameter(name = "xml_contract", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_transaction_property", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_contract_history", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_edit",
                procedureName = "vpcc_npo_contract_edit",
                parameters = {
                        @StoredProcedureParameter(name = "xml_contract", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_transaction_property", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_contract_history", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_delete",
                procedureName = "vpcc_npo_contract_delete",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_contract_history", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_cancel",
                procedureName = "vpcc_npo_contract_cancel",
                parameters = {
                        @StoredProcedureParameter(name = "contract_cancel_id ", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_contract", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_transaction_property", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "xml_contract_history", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_report_by_notary",
                procedureName = "vpcc_npo_report_by_notary",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_report_by_notary_count_total",
                procedureName = "vpcc_npo_report_by_notary_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_report_by_user",
                procedureName = "vpcc_npo_report_by_user",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_report_by_user_count_total",
                procedureName = "vpcc_npo_report_by_user_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_update",
                procedureName = "vpcc_npo_contract_update",
                parameters = {
                        @StoredProcedureParameter(name = "xml_content", type = String.class, mode = ParameterMode.IN)
                }
        ),

        @NamedStoredProcedureQuery(
                name = "stp_npo_contract_history_select_by_filter",
                procedureName = "stp_npo_contract_history_select_by_filter",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_contract_history_count_total",
                procedureName = "stp_npo_contract_history_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_select_report_by_group_total",
                procedureName = "stp_npo_select_report_by_group_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_count_by_kind_code",
                procedureName = "vpcc_npo_contract_count_by_kind_code",
                parameters = {
                        @StoredProcedureParameter(name = "kind_code", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),

        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_error",
                procedureName = "vpcc_npo_contract_error",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_count_notary",
                procedureName = "vpcc_npo_contract_count_notary",
                parameters = {
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_count_notary_hop_danh",
                procedureName = "vpcc_npo_contract_count_notary_hop_danh",
                parameters = {
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_count_cost_total_tt20",
                procedureName = "vpcc_npo_contract_count_cost_total_tt20",
                parameters = {
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_select_contract_template_by_id",
                procedureName = "vpcc_npo_select_contract_template_by_id",
                resultClasses = {ContractTemplateBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_select_contract_kind_by_contract_template_id",
                procedureName = "vpcc_npo_select_contract_kind_by_contract_template_id",
                resultClasses = {ContractKindBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_select_contract_kind_by_contract_template_code",
                procedureName = "vpcc_npo_select_contract_kind_by_contract_template_code",
                resultClasses = {ContractKindBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "code_temp", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_report_contract_additional",
                procedureName = "vpcc_npo_report_contract_additional",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_report_contract_certify",
                procedureName = "vpcc_npo_report_contract_certify",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_contact_stastics_bank",
                procedureName = "vpcc_contact_stastics_bank",
                parameters = {
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_contract_stastics_drafter",
                procedureName = "vpcc_contract_stastics_drafter",
                parameters = {
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_contract_statistic_notary",
                procedureName = "vpcc_contract_statistic_notary",
                parameters = {
                        @StoredProcedureParameter(name = "notaryDateFromFilter", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "notaryDateToFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_count_by_contract_number",
                procedureName = "vpcc_npo_contract_count_by_contract_number",
                parameters = {
                        @StoredProcedureParameter(name = "contract_number", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_contract_select_lastest_count",
                procedureName = "vpcc_npo_contract_select_lastest_count",
                resultClasses = {ContractBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "countNumber", type = Long.class, mode = ParameterMode.IN)
                }
        )

})


public class ContractBO extends AbstractAuditEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "contract_template_id")
    private Long contract_template_id;

    @Column(name = "contract_number")
    private String contract_number;

    @Column(name = "contract_value")
    private String contract_value;

    @Column(name = "relation_object_a")
    private String relation_object_a;

    @Column(name = "relation_object_b")
    private String relation_object_b;

    @Column(name = "relation_object_c")
    private String relation_object_c;

    @Column(name = "notary_id")
    private Long notary_id;

    @Column(name = "drafter_id")
    private Long drafter_id;

    @Column(name = "received_date")
    private java.sql.Timestamp received_date;

    @Column(name = "notary_date")
    private java.sql.Timestamp notary_date;

    @Column(name = "user_require_contract")
    private String user_require_contract;

    @Column(name = "number_copy_of_contract")
    private String number_copy_of_contract;

    @Column(name = "number_of_page")
    private String number_of_page;

    @Column(name = "cost_tt91")
    private Long cost_tt91;

    @Column(name = "cost_draft")
    private Long cost_draft;

    @Column(name = "cost_notary_outsite")
    private Long cost_notary_outsite;

    @Column(name = "cost_other_determine")
    private Long cost_other_determine;

    @Column(name = "cost_total")
    private Long cost_total;

    @Column(name = "notary_place_flag")
    private Long notary_place_flag;

    @Column(name = "notary_place")
    private String notary_place;

    @Column(name = "bank_id")
    private Long bank_id;

    @Column(name = "bank_service_fee")
    private String bank_service_fee;

    @Column(name = "crediter_name")
    private String crediter_name;

    @Column(name = "file_name")
    private String file_name;

    @Column(name = "file_path")
    private String file_path;

    @Column(name = "error_status")
    private Long error_status;

    @Column(name = "error_user_id")
    private Long error_user_id;

    @Column(name = "error_description")
    private String error_description;

    @Column(name = "addition_status")
    private Long addition_status;

    @Column(name = "addition_description")
    private String addition_description;

    @Column(name = "cancel_status")
    private Long cancel_status;

    @Column(name = "cancel_description")
    private String cancel_description;

    @Column(name = "cancel_relation_contract_id")
    private Long cancel_relation_contract_id;

    @Column(name = "contract_period")
    private String contract_period;

    @Column(name = "mortage_cancel_flag")
    private Long mortage_cancel_flag;

    @Column(name = "mortage_cancel_date")
    private String mortage_cancel_date;

    @Column(name = "mortage_cancel_note")
    private String mortage_cancel_note;

    @Column(name = "original_store_place")
    private String original_store_place;

    @Column(name = "note")
    private String note;

    @Column(name = "summary")
    private String summary;

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

    @Column(name = "bank_name")
    private String bank_name;

    @Column(name = "jsonstring")
    private String jsonstring;

    @Column(name = "kindhtml")
    private String kindhtml;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @Column(name = "bank_code")
    private String bank_code;

    @Column(name = "json_property")
    private String json_property;

    @Column(name = "json_person")
    private String json_person;

    public ContractBO(Long id,Long contract_template_id, String contract_number, String contract_value, String relation_object_a, String relation_object_b, String relation_object_c, Long notary_id, Long drafter_id, Timestamp received_date, Timestamp notary_date, String user_require_contract, String number_copy_of_contract, String number_of_page, Long cost_tt91, Long cost_draft, Long cost_notary_outsite, Long cost_other_determine, Long cost_total, Long notary_place_flag, String notary_place, Long bank_id, String bank_service_fee, String crediter_name, String file_name, String file_path, Long error_status, Long error_user_id, String error_description, Long addition_status, String addition_description, Long cancel_status, String cancel_description, Long cancel_relation_contract_id, String contract_period, Long mortage_cancel_flag, String mortage_cancel_date, String mortage_cancel_note, String original_store_place, String note, String summary, Long entry_user_id, String entry_user_name, Timestamp entry_date_time, Long update_user_id, String update_user_name, Timestamp update_date_time, String bank_name, String jsonstring, String kindhtml, String content, String title, String bank_code, String json_property, String json_person) {
        this.id=id;
        this.contract_template_id = contract_template_id;
        this.contract_number = contract_number;
        this.contract_value = contract_value;
        this.relation_object_a = relation_object_a;
        this.relation_object_b = relation_object_b;
        this.relation_object_c = relation_object_c;
        this.notary_id = notary_id;
        this.drafter_id = drafter_id;
        this.received_date = received_date;
        this.notary_date = notary_date;
        this.user_require_contract = user_require_contract;
        this.number_copy_of_contract = number_copy_of_contract;
        this.number_of_page = number_of_page;
        this.cost_tt91 = cost_tt91;
        this.cost_draft = cost_draft;
        this.cost_notary_outsite = cost_notary_outsite;
        this.cost_other_determine = cost_other_determine;
        this.cost_total = cost_total;
        this.notary_place_flag = notary_place_flag;
        this.notary_place = notary_place;
        this.bank_id = bank_id;
        this.bank_service_fee = bank_service_fee;
        this.crediter_name = crediter_name;
        this.file_name = file_name;
        this.file_path = file_path;
        this.error_status = error_status;
        this.error_user_id = error_user_id;
        this.error_description = error_description;
        this.addition_status = addition_status;
        this.addition_description = addition_description;
        this.cancel_status = cancel_status;
        this.cancel_description = cancel_description;
        this.cancel_relation_contract_id = cancel_relation_contract_id;
        this.contract_period = contract_period;
        this.mortage_cancel_flag = mortage_cancel_flag;
        this.mortage_cancel_date = mortage_cancel_date;
        this.mortage_cancel_note = mortage_cancel_note;
        this.original_store_place = original_store_place;
        this.note = note;
        this.summary = summary;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.entry_date_time = entry_date_time;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.update_date_time = update_date_time;
        this.bank_name = bank_name;
        this.jsonstring = jsonstring;
        this.kindhtml = kindhtml;
        this.content = content;
        this.title = title;
        this.bank_code = bank_code;
        this.json_property = json_property;
        this.json_person = json_person;
    }

    public ContractBO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContract_template_id() {
        return contract_template_id;
    }

    public void setContract_template_id(Long contract_template_id) {
        this.contract_template_id = contract_template_id;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getContract_value() {
        return contract_value;
    }

    public void setContract_value(String contract_value) {
        this.contract_value = contract_value;
    }

    public String getRelation_object_a() {
        return relation_object_a;
    }

    public void setRelation_object_a(String relation_object_a) {
        this.relation_object_a = relation_object_a;
    }

    public String getRelation_object_b() {
        return relation_object_b;
    }

    public void setRelation_object_b(String relation_object_b) {
        this.relation_object_b = relation_object_b;
    }

    public String getRelation_object_c() {
        return relation_object_c;
    }

    public void setRelation_object_c(String relation_object_c) {
        this.relation_object_c = relation_object_c;
    }

    public Long getNotary_id() {
        return notary_id;
    }

    public void setNotary_id(Long notary_id) {
        this.notary_id = notary_id;
    }

    public Long getDrafter_id() {
        return drafter_id;
    }

    public void setDrafter_id(Long drafter_id) {
        this.drafter_id = drafter_id;
    }

    public Timestamp getReceived_date() {
        return received_date;
    }

    public void setReceived_date(Timestamp received_date) {
        this.received_date = received_date;
    }

    public Timestamp getNotary_date() {
        return notary_date;
    }

    public void setNotary_date(Timestamp notary_date) {
        this.notary_date = notary_date;
    }

    public String getUser_require_contract() {
        return user_require_contract;
    }

    public void setUser_require_contract(String user_require_contract) {
        this.user_require_contract = user_require_contract;
    }

    public String getNumber_copy_of_contract() {
        return number_copy_of_contract;
    }

    public void setNumber_copy_of_contract(String number_copy_of_contract) {
        this.number_copy_of_contract = number_copy_of_contract;
    }

    public String getNumber_of_page() {
        return number_of_page;
    }

    public void setNumber_of_page(String number_of_page) {
        this.number_of_page = number_of_page;
    }

    public Long getCost_tt91() {
        return cost_tt91;
    }

    public void setCost_tt91(Long cost_tt91) {
        this.cost_tt91 = cost_tt91;
    }

    public Long getCost_draft() {
        return cost_draft;
    }

    public void setCost_draft(Long cost_draft) {
        this.cost_draft = cost_draft;
    }

    public Long getCost_notary_outsite() {
        return cost_notary_outsite;
    }

    public void setCost_notary_outsite(Long cost_notary_outsite) {
        this.cost_notary_outsite = cost_notary_outsite;
    }

    public Long getCost_other_determine() {
        return cost_other_determine;
    }

    public void setCost_other_determine(Long cost_other_determine) {
        this.cost_other_determine = cost_other_determine;
    }

    public Long getCost_total() {
        return cost_total;
    }

    public void setCost_total(Long cost_total) {
        this.cost_total = cost_total;
    }

    public Long getNotary_place_flag() {
        return notary_place_flag;
    }

    public void setNotary_place_flag(Long notary_place_flag) {
        this.notary_place_flag = notary_place_flag;
    }

    public String getNotary_place() {
        return notary_place;
    }

    public void setNotary_place(String notary_place) {
        this.notary_place = notary_place;
    }

    public Long getBank_id() {
        return bank_id;
    }

    public void setBank_id(Long bank_id) {
        this.bank_id = bank_id;
    }

    public String getBank_service_fee() {
        return bank_service_fee;
    }

    public void setBank_service_fee(String bank_service_fee) {
        this.bank_service_fee = bank_service_fee;
    }

    public String getCrediter_name() {
        return crediter_name;
    }

    public void setCrediter_name(String crediter_name) {
        this.crediter_name = crediter_name;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Long getError_status() {
        return error_status;
    }

    public void setError_status(Long error_status) {
        this.error_status = error_status;
    }

    public Long getError_user_id() {
        return error_user_id;
    }

    public void setError_user_id(Long error_user_id) {
        this.error_user_id = error_user_id;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public Long getAddition_status() {
        return addition_status;
    }

    public void setAddition_status(Long addition_status) {
        this.addition_status = addition_status;
    }

    public String getAddition_description() {
        return addition_description;
    }

    public void setAddition_description(String addition_description) {
        this.addition_description = addition_description;
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

    public Long getCancel_relation_contract_id() {
        return cancel_relation_contract_id;
    }

    public void setCancel_relation_contract_id(Long cancel_relation_contract_id) {
        this.cancel_relation_contract_id = cancel_relation_contract_id;
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

    public String getOriginal_store_place() {
        return original_store_place;
    }

    public void setOriginal_store_place(String original_store_place) {
        this.original_store_place = original_store_place;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public Timestamp getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(Timestamp entry_date_time) {
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

    public Timestamp getUpdate_date_time() {
        return update_date_time;
    }

    public void setUpdate_date_time(Timestamp update_date_time) {
        this.update_date_time = update_date_time;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getJsonstring() {
        return jsonstring;
    }

    public void setJsonstring(String jsonstring) {
        this.jsonstring = jsonstring;
    }

    public String getKindhtml() {
        return kindhtml;
    }

    public void setKindhtml(String kindhtml) {
        this.kindhtml = kindhtml;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
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
