package com.vn.osp.notarialservices.contract.dto;

import java.sql.Timestamp;

/**
 * Created by minh on 5/24/2017.
 */
public class ContractCertify {
    private String contract_number;
    private String notary_date;
    private String relate_object_A_display;
    private String relate_object_B_display;
    private String relate_object_C_display;
    private String relation_object_A;
    private String relation_object_B;
    private String relation_object_C;
    private String name;
    private String notary_family_name;
    private String notary_first_name;
    private String cost_total;
    private String note;

    public ContractCertify(){

    }


    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public String getNotary_date() {
        return notary_date;
    }

    public void setNotary_date(String notary_date) {
        this.notary_date = notary_date;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotary_family_name() {
        return notary_family_name;
    }

    public void setNotary_family_name(String notary_family_name) {
        this.notary_family_name = notary_family_name;
    }

    public String getNotary_first_name() {
        return notary_first_name;
    }

    public void setNotary_first_name(String notary_first_name) {
        this.notary_first_name = notary_first_name;
    }

    public String getCost_total() {
        return cost_total;
    }

    public void setCost_total(String cost_total) {
        this.cost_total = cost_total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
