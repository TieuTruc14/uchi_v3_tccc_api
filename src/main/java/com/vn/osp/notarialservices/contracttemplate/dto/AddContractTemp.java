package com.vn.osp.notarialservices.contracttemplate.dto;

/**
 * Created by Admin on 7/6/2017.
 */
public class AddContractTemp {
    private String id;
    private String name;
    private String code;
    private String description;
    private Long active_flg;
    private Long relate_object_number;
    private Long period_flag;
    private Long mortage_cancel_func;
    private Long entry_user_id;
    private String entry_user_name;
    private String kind_html;
    private String office_code;
    private String code_template;

    public AddContractTemp() {
    }

    public AddContractTemp(String id,String name, String code, String description, Long active_flg, Long relate_object_number, Long period_flag, Long mortage_cancel_func, Long entry_user_id, String entry_user_name, String kind_html, String office_code, String code_template) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.active_flg = active_flg;
        this.relate_object_number = relate_object_number;
        this.period_flag = period_flag;
        this.mortage_cancel_func = mortage_cancel_func;
        this.entry_user_id = entry_user_id;
        this.entry_user_name = entry_user_name;
        this.kind_html = kind_html;
        this.office_code = office_code;
        this.code_template = code_template;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode_template() {
        return code_template;
    }

    public void setCode_template(String code_template) {
        this.code_template = code_template;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Long getMortage_cancel_func() {
        return mortage_cancel_func;
    }

    public void setMortage_cancel_func(Long mortage_cancel_func) {
        this.mortage_cancel_func = mortage_cancel_func;
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
