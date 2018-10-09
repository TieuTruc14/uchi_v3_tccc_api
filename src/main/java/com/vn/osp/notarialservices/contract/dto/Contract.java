package com.vn.osp.notarialservices.contract.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by TienManh on 5/11/2017.
 */
@XStreamAlias("Contract")
public class Contract extends BaseEntityBeans{

    private Long id;
    private Long contract_template_id;
    private String contract_number;
    private String contract_value;
    private String relation_object_a;
    private String relation_object_b;
    private String relation_object_c;
    private Long notary_id;
    private Long drafter_id;
    private String received_date;
    private String notary_date;
    private String user_require_contract;
    private String number_copy_of_contract;
    private String number_of_page;
    private Long cost_tt91;
    private Long cost_draft;
    private Long cost_notary_outsite;
    private Long cost_other_determine;
    private Long cost_total;
    private Long notary_place_flag;
    private String notary_place;
    private Long bank_id;
    private String bank_service_fee;
    private String crediter_name;
    private String file_name;
    private String file_path;
    private Long error_status;
    private Long error_user_id;
    private String error_description;
    private Long addition_status;
    private String addition_description;
    private Long cancel_status;
    private String cancel_description;
    private Long cancel_relation_contract_id;
    private String contract_period;
    private Long mortage_cancel_flag;
    private String mortage_cancel_date;
    private String mortage_cancel_note;
    private String original_store_place;
    private String note;
    private String summary;
    private Long entry_user_id;
    private String entry_user_name;
    private Timestamp entry_date_time;
    private Long update_user_id;
    private String update_user_name;
    private Timestamp update_date_time;
    private String bank_name;
    private String jsonstring;
    private String kindhtml;
    private String content;
    private String title;
    private String bank_code;
    private String json_property;
    private String json_person;


    public Contract(){}

    @JsonCreator
    public Contract(
            @JsonProperty(value="id",required= true) final Long id,
            @JsonProperty(value="contract_template_id",required= true) final Long contract_template_id,
            @JsonProperty(value="contract_number",required= true) final String contract_number,
            @JsonProperty(value="contract_value",required= true) final String contract_value,
            @JsonProperty(value="relation_object_a",required= true) final String relation_object_a,
            @JsonProperty(value="relation_object_b",required= true) final String relation_object_b,
            @JsonProperty(value="relation_object_c",required= true) final String relation_object_c,
            @JsonProperty(value="notary_id",required= true) final Long notary_id,
            @JsonProperty(value="drafter_id",required= true) final Long drafter_id,
            @JsonProperty(value="received_date",required= true) final String received_date,
            @JsonProperty(value="notary_date",required= true) final String notary_date,
            @JsonProperty(value="user_require_contract",required= true) final String user_require_contract,
            @JsonProperty(value="number_copy_of_contract",required= true) final String number_copy_of_contract,
            @JsonProperty(value="number_of_page",required= true) final String number_of_page,
            @JsonProperty(value="cost_tt91",required= true) final Long cost_tt91,
            @JsonProperty(value="cost_draft",required= true) final Long cost_draft,
            @JsonProperty(value="cost_notary_outsite",required= true) final Long cost_notary_outsite,
            @JsonProperty(value="cost_other_determine",required= true) final Long cost_other_determine,
            @JsonProperty(value="cost_total",required= true) final Long cost_total,
            @JsonProperty(value="notary_place_flag",required= true) final Long notary_place_flag,
            @JsonProperty(value="notary_place",required= true) final String notary_place,
            @JsonProperty(value="bank_id",required= true) final Long bank_id,
            @JsonProperty(value="bank_service_fee",required= true) final String bank_service_fee,
            @JsonProperty(value="crediter_name",required= true) final String crediter_name,
            @JsonProperty(value="file_name",required= true) final String file_name,
            @JsonProperty(value="file_path",required= true) final String file_path,
            @JsonProperty(value="error_status",required= true) final Long error_status,
            @JsonProperty(value="error_user_id",required= true) final Long error_user_id,
            @JsonProperty(value="error_description",required= true) final String error_description,
            @JsonProperty(value="addition_status",required= true) final Long addition_status,
            @JsonProperty(value="addition_description",required= true) final String addition_description,
            @JsonProperty(value="cancel_status",required= true) final Long cancel_status,
            @JsonProperty(value="cancel_description",required= true) final String cancel_description,
            @JsonProperty(value="cancel_relation_contract_id",required= true) final Long cancel_relation_contract_id,
            @JsonProperty(value="contract_period",required= true) final String contract_period,
            @JsonProperty(value="mortage_cancel_flag",required= true) final Long mortage_cancel_flag,
            @JsonProperty(value="mortage_cancel_date",required= true) final String mortage_cancel_date,
            @JsonProperty(value="mortage_cancel_note",required= true) final String mortage_cancel_note,
            @JsonProperty(value="original_store_place",required= true) final String original_store_place,
            @JsonProperty(value="note",required= true) final String note,
            @JsonProperty(value="summary",required= true) final String summary,
            @JsonProperty(value="entry_user_id",required= true) final Long entry_user_id,
            @JsonProperty(value="entry_user_name",required= true) final String entry_user_name,
            @JsonProperty(value="entry_date_time",required= true) final Timestamp entry_date_time,
            @JsonProperty(value="update_user_id",required= true) final Long update_user_id,
            @JsonProperty(value="update_user_name",required= true) final String update_user_name,
            @JsonProperty(value="update_date_time",required= true) final Timestamp update_date_time,
            @JsonProperty(value="bank_name",required= true) final String bank_name,
            @JsonProperty(value="jsonstring",required= true) final String jsonstring,
            @JsonProperty(value="kindhtml",required= true) final String kindhtml,
            @JsonProperty(value="content",required= true) final String content,
            @JsonProperty(value="title",required= true) final String title,
            @JsonProperty(value="bank_code",required= true) final String bank_code,
            @JsonProperty(value="json_property",required= true) final String json_property,
            @JsonProperty(value="json_person",required= true) final String json_person
    ) {
        this.id = id;
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
        this.bank_code=bank_code;
        this.json_property=json_property;
        this.json_person=json_person;
    }



    public Long getid() {
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

    public String getReceived_date() {
        return received_date;
    }

    public void setReceived_date(String received_date) {
        this.received_date = received_date;
    }

    public String getNotary_date() {
        return notary_date;
    }

    public void setNotary_date(String notary_date) {
        this.notary_date = notary_date;
    }

    public Timestamp getEntry_date_time() {
        return entry_date_time;
    }

    public void setEntry_date_time(Timestamp entry_date_time) {
        this.entry_date_time = entry_date_time;
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
