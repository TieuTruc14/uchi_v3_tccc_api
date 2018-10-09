package com.vn.osp.notarialservices.systemmanager.domain;

import com.vn.osp.notarialservices.common.domain.AbstractAuditEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by manhtran on 20/10/2016.
 */
@Data
@Entity
@Table(name = "npo_access_history")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "stp_npo_access_history_count_total",
                procedureName = "stp_npo_access_history_count_total",
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        ),
        @NamedStoredProcedureQuery(
                name = "stp_npo_access_history_select_by_filter",
                procedureName = "stp_npo_access_history_select_by_filter",
                resultClasses = { AccessHistoryBO.class },
                parameters = {
                        @StoredProcedureParameter(name = "stringFilter", type = String.class, mode = ParameterMode.IN),
                }
        )
        ,
        @NamedStoredProcedureQuery(
                name = "stp_npo_access_history_add",
                procedureName = "stp_npo_access_history_add",
                resultClasses = { AccessHistoryBO.class },
                parameters = {
                        @StoredProcedureParameter(name = "usid", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "execute_person", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "client_info", type = String.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "access_type", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "description", type = String.class, mode = ParameterMode.IN),
                }
        )
})
public class AccessHistoryBO extends AbstractAuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hid", nullable = false)
    private Integer id;

    @Column(name="access_type")
    private Integer accessType;

    @Column(name="client_info")
    private String clientInfo;

    @Column(name="execute_date_time")
    private Timestamp executeDateTime;

    @Column(name="execute_person")
    private String executePerson;

    @Column(name="description")
    private String description;

    private int usid;

    public AccessHistoryBO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public String getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }

    public Timestamp getExecuteDateTime() {
        return executeDateTime;
    }

    public void setExecuteDateTime(Timestamp executeDateTime) {
        this.executeDateTime = executeDateTime;
    }

    public String getExecutePerson() {
        return executePerson;
    }

    public void setExecutePerson(String executePerson) {
        this.executePerson = executePerson;
    }

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
