package com.vn.osp.notarialservices.contract.dto;

import java.sql.Timestamp;

/**
 * Created by minh on 5/19/2017.
 */
public class ReportByUser {
    private Integer id;
    private String contract_number;
    private String contract_name;
    private String relate_object_A_display;
    private String relate_object_B_display;
    private String relate_object_C_display;
    private String relation_object_A;
    private String relation_object_B;
    private String relation_object_C;
    private Timestamp notary_date;
    private String family_name;
    private String first_name;
    private Integer drafter_id;
    private String drafter_family_name;
    private String drafter_first_name;
    private String summary;

    public ReportByUser(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRelation_object_A() {
        return relation_object_A;
    }

    public void setRelation_object_A(String relation_object_A) {
        this.relation_object_A = relation_object_A;
    }

    public String getRelation_object_B() {
        return relation_object_B;
    }

    public void setRelation_object_B(String relation_object_B) {
        this.relation_object_B = relation_object_B;
    }

    public String getRelation_object_C() {
        return relation_object_C;
    }

    public void setRelation_object_C(String relation_object_C) {
        this.relation_object_C = relation_object_C;
    }

    public Timestamp getNotary_date() {
        return notary_date;
    }

    public void setNotary_date(Timestamp notary_date) {
        this.notary_date = notary_date;
    }


    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Integer getDrafter_id() {
        return drafter_id;
    }

    public void setDrafter_id(Integer drafter_id) {
        this.drafter_id = drafter_id;
    }

    public String getDrafter_family_name() {
        return drafter_family_name;
    }

    public void setDrafter_family_name(String drafter_family_name) {
        this.drafter_family_name = drafter_family_name;
    }

    public String getDrafter_first_name() {
        return drafter_first_name;
    }

    public void setDrafter_first_name(String drafter_first_name) {
        this.drafter_first_name = drafter_first_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
