package com.vn.osp.notarialservices.user.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "npo_grouprole")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_select_by_filter",
                procedureName = "stp_npo_grouprole_select_by_filter",
                resultClasses = {GroupRoleBO.class},
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_user_get_grouprole_by_user",
                procedureName = "stp_npo_user_get_grouprole_by_user",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_user_authority_delete",
                procedureName = "stp_npo_user_authority_delete",
                parameters = {
                        @StoredProcedureParameter(name = "userId", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_user_authority_add",
                procedureName = "stp_npo_user_authority_add",
                parameters = {
                        @StoredProcedureParameter(name = "userId", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "groupId", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_authority_add",
                procedureName = "stp_npo_grouprole_authority_add",
                parameters = {
                        @StoredProcedureParameter(name = "grouprole_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "authority_code", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "value", type = Integer.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_add",
                procedureName = "stp_npo_grouprole_add",
                parameters = {
                        @StoredProcedureParameter(name = "grouprolename", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "description", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "active_flg", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entry_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "entry_user_name", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_authority_delete",
                procedureName = "stp_npo_grouprole_authority_delete",
                parameters = {
                        @StoredProcedureParameter(name = "grouprole_id", type = Long.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_update",
                procedureName = "stp_npo_grouprole_update",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "grouprolename", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "description", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "active_flg", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "update_user_name", type = String.class, mode = ParameterMode.IN)

                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_authority_select_by_filter",
                procedureName = "stp_npo_grouprole_authority_select_by_filter",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_count_total",
                procedureName = "stp_npo_grouprole_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_authority_update_value",
                procedureName = "stp_npo_grouprole_authority_update_value",
                parameters = {
                        @StoredProcedureParameter(name = "grouprole_id", type = Long.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "authority_code", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "value", type = Integer.class, mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_grouprole_delete",
                procedureName = "stp_npo_grouprole_delete",
                parameters = {
                        @StoredProcedureParameter(name = "id", type = Long.class, mode = ParameterMode.IN)
                }
        ),

})
public class GroupRoleBO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="grouprolename",length = 200)
    private String grouprolename;
    @Column(name="description",length = 1000)
    private String description;
    private Long active_flg;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrouprolename() {
        return grouprolename;
    }

    public void setGrouprolename(String grouprolename) {
        this.grouprolename = grouprolename;
    }

    public Long getActive_flg() {
        return active_flg;
    }

    public void setActive_flg(Long active_flg) {
        this.active_flg = active_flg;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
