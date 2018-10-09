package com.vn.osp.notarialservices.user.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "npo_authority")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_authority_select_by_filter",
                procedureName = "stp_npo_authority_select_by_filter",
                resultClasses = {AuthorityBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_user_authority_count_by_filter",
                procedureName = "stp_npo_user_authority_count_by_filter",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_user_authority_select_by_filter",
                procedureName = "stp_npo_user_authority_select_by_filter",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),

})
public class AuthorityBO {

    @Id
    @Column(name = "code", nullable = false)
    private String code;

    private String name;
    private Long entry_user_id;
    private String entry_user_name;
    private java.sql.Timestamp entry_date_time;
    private Long update_user_id;
    private String update_user_name;
    private java.sql.Timestamp update_date_time;
    private Long type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
