package com.vn.osp.notarialservices.bank.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by minh on 2/22/2017.
 */
@Data
@Entity
@Table(name = "npo_bank")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "selectBank",
                procedureName = "stp_npo_bank_select",
                resultClasses = {BankBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }),

        @NamedStoredProcedureQuery(
                name = "stp_npo_bank_getAll",
                procedureName = "stp_npo_bank_getAll",
                resultClasses = {BankBo.class}
                ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_bank_count",
                procedureName = "stp_npo_bank_count",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "addBank",
                procedureName = "osp_bank_add",
                parameters = {
                        @StoredProcedureParameter(name = "name",type = String.class, mode= ParameterMode.IN),
                        @StoredProcedureParameter(name= "entry_user_id",type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name= "entry_user_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "code", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "active", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_bank_update",
                procedureName = "stp_npo_bank_update",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "order_number", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_name", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_date_time", type = java.sql.Timestamp.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "active", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_bank_get_by_id",
                procedureName = "vpcc_npo_bank_get_by_id",
                resultClasses = {BankBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "id", type = String.class, mode = ParameterMode.IN)
                }),
        @NamedStoredProcedureQuery(
                name = "vpcc_npo_bank_get_by_code",
                procedureName = "vpcc_npo_bank_get_by_code",
                resultClasses = {BankBo.class},
                parameters = {
                        @StoredProcedureParameter(name = "code", type = String.class, mode = ParameterMode.IN)
                }),

})
public class BankBo extends AbstractAuditEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;


    @Column(name = "order_number")
    private Long order_number;

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

    @Column(name = "active")
    private Long active;


    public Integer getSid() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSid(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }
}
