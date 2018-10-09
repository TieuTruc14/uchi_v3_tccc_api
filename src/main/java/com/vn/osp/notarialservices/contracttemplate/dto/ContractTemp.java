package com.vn.osp.notarialservices.contracttemplate.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.vn.osp.notarialservices.common.dto.BaseEntityBeans;

/**
 * Created by Admin on 7/6/2017.
 */
@XStreamAlias("ContractTemp")
public class ContractTemp extends BaseEntityBeans {
    private String id;
    private String name;
    private Long kind_id;
    private Long kind_id_tt08;
    private String code;
    private String description;
    private String file_name;
    private String file_path;
    private Long active_flg;
    private Long relate_object_number;
    private String relate_object_A_display;
    private String relate_object_B_display;
    private String relate_object_C_display;
    private Long period_flag;
    private Long period_req_flag;
    private Long mortage_cancel_func;
    private Long sync_option;
    private Long entry_user_id;
    private String entry_user_name;
    private String entry_date_time;
    private Long update_user_id;
    private String update_user_name;
    private String update_date_time;
    private String kind_html;
    private String office_code;
    private String code_template;
    @JsonCreator
    public ContractTemp(
            @JsonProperty(value = "id") final String id,
            @JsonProperty(value = "name") final String name,
            @JsonProperty(value = "kind_id") final Long kind_id,
            @JsonProperty(value = "kind_id_tt08")final Long kind_id_tt08,
            @JsonProperty(value = "code") final String code,
            @JsonProperty(value = "description") final String description,
            @JsonProperty(value = "file_name") final String file_name,
            @JsonProperty(value = "file_path") final String file_path,
            @JsonProperty(value = "active_flg") final Long active_flg,
            @JsonProperty(value = "relate_object_number") final Long relate_object_number,
            @JsonProperty(value = "relate_object_A_display") final String relate_object_A_display,
            @JsonProperty(value = "relate_object_B_display") final String relate_object_B_display,
            @JsonProperty(value = "relate_object_C_display") final String relate_object_C_display,
            @JsonProperty(value = "period_flag") final Long period_flag,
            @JsonProperty(value = "period_req_flag") final Long period_req_flag,
            @JsonProperty(value = "mortage_cancel_func") final Long mortage_cancel_func,
            @JsonProperty(value = "sync_option") final Long sync_option,
            @JsonProperty(value = "entry_user_id") final Long entry_user_id,
            @JsonProperty(value = "entry_user_name") final String entry_user_name,
            @JsonProperty(value = "entry_date_time") final String entry_date_time,
            @JsonProperty(value = "update_user_id") final Long update_user_id,
            @JsonProperty(value = "update_user-name") final String update_user_name,
            @JsonProperty(value = "update_date_time") final String update_date_time,
            @JsonProperty(value = "kind_html") final String kind_html,
            @JsonProperty(value = "office_code") final String office_code,
            @JsonProperty(value = "code_template") final String code_template){
        this.id = id;
        this.name = name;
        this.kind_id = kind_id;
        this.kind_id_tt08 = kind_id_tt08;
        this.code = code;
        this.description = description;
        this.file_name = file_name;
        this.file_path = file_path;
        this.active_flg = active_flg;
        this.relate_object_number = relate_object_number;
        this.relate_object_A_display = relate_object_A_display;
        this.relate_object_B_display = relate_object_B_display;
        this.relate_object_C_display = relate_object_C_display;
        this.period_flag = period_flag;
        this.period_req_flag = period_req_flag;
        this.mortage_cancel_func = mortage_cancel_func;
        this.sync_option = sync_option;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.entry_date_time = entry_date_time;
        this.update_user_id = update_user_id;
        this.update_user_name = update_user_name;
        this.update_date_time = update_date_time;
        this.kind_html = kind_html;
        this.office_code = office_code;
        this.code_template = code_template;

    }

    public ContractTemp() {
    }

    public String getRelate_object_A_display() {
        return relate_object_A_display;
    }

    public void setRelate_object_A_display(String relate_object_A_display) {
        this.relate_object_A_display = relate_object_A_display;
    }

    public String getRelate_object_B_display() {
        return relate_object_B_display;
    }

    public void setRelate_object_B_display(String relate_object_B_display) {
        this.relate_object_B_display = relate_object_B_display;
    }

    public String getRelate_object_C_display() {
        return relate_object_C_display;
    }

    public void setRelate_object_C_display(String relate_object_C_display) {
        this.relate_object_C_display = relate_object_C_display;
    }

    public String getCode_template() {
        return code_template;
    }

    public void setCode_template(String code_template) {
        this.code_template = code_template;
    }

    public String getSid() {
        return id;
    }

    public void setSid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getKind_id() {
        return kind_id;
    }

    public void setKind_id(Long kind_id) {
        this.kind_id = kind_id;
    }

    public Long getKind_id_tt08() {
        return kind_id_tt08;
    }

    public void setKind_id_tt08(Long kind_id_tt08) {
        this.kind_id_tt08 = kind_id_tt08;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getActive_flg() {
        return active_flg;
    }

    public void setActive_flg(Long active_flg) {
        this.active_flg = active_flg;
    }

    public Long getRelate_object_number() {
        return relate_object_number;
    }

    public void setRelate_object_number(Long relate_object_number) {
        this.relate_object_number = relate_object_number;
    }

    public Long getPeriod_flag() {
        return period_flag;
    }

    public void setPeriod_flag(Long period_flag) {
        this.period_flag = period_flag;
    }

    public Long getPeriod_req_flag() {
        return period_req_flag;
    }

    public void setPeriod_req_flag(Long period_req_flag) {
        this.period_req_flag = period_req_flag;
    }

    public Long getMortage_cancel_func() {
        return mortage_cancel_func;
    }

    public void setMortage_cancel_func(Long mortage_cancel_func) {
        this.mortage_cancel_func = mortage_cancel_func;
    }

    public Long getSync_option() {
        return sync_option;
    }

    public void setSync_option(Long sync_option) {
        this.sync_option = sync_option;
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

    public String getKind_html() {
        return kind_html;
    }

    public void setKind_html(String kind_html) {
        this.kind_html = kind_html;
    }

    public String getOffice_code() {
        return office_code;
    }

    public void setOffice_code(String office_code) {
        this.office_code = office_code;
    }

}
